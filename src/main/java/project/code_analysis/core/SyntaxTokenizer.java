package project.code_analysis.core;

import project.code_analysis.core.ISyntaxFacts;
import project.code_analysis.core.SyntaxToken;

import java.util.ArrayList;
import java.util.Set;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class SyntaxTokenizer {
    private ISyntaxFacts syntaxFacts;
    private TokenizerSession currentSession;
    private TokenizerState currentState = TokenizerState.LEADING_SPACE;
    private int currentPosition = 0;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();

    public SyntaxTokenizer(ISyntaxFacts syntaxFacts) {
        this.syntaxFacts = syntaxFacts;
    }

    public ISyntaxFacts getSyntaxFacts() {
        return this.syntaxFacts;
    }

    private Set<String> getSpecialSymbolList() {
        return this.getSyntaxFacts().getSpecialSymbolList();
    }

    private Set<String> getChangeLineSymbols() {
        return this.getSyntaxFacts().getChangeLineSymbols();
    }

    private Set<Character> getPostDigitLabelList() {
        return this.getSyntaxFacts().getPostDigitLabelList();
    }

    private boolean isSpecialSymbol(char c) {
        return this.isSpecialSymbol("" + c);
    }

    private boolean isSpecialSymbol(String s) {
        return this.getSpecialSymbolList().contains(s);
    }

    private boolean isPartialSpecialToken(char c) {
        return this.isPartialSpecialToken("" + c);
    }

    private boolean isPartialSpecialToken(String s) {
        if (s != null) {
            for (String token : this.getSpecialSymbolList()) {
                if (s.length() <= token.length() && token.substring(0, s.length()).equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInState(TokenizerState state) {
        return this.currentState == state;
    }

    private void submitSession() {
        this.tokenList.add(this.currentSession.getToken());
        this.createNewSession();
        this.changeState(TokenizerState.LEADING_SPACE);
    }

    private void createNewSession() {
        if (this.currentSession == null) {
            this.currentSession = new TokenizerSession(this.currentPosition, this.currentPosition);
        } else {
            this.currentSession.clear(this.currentPosition, this.currentPosition);
        }
    }

    private void changeState(TokenizerState newState) {
        this.currentState = newState;
    }

    public ArrayList<SyntaxToken> tokenize(String source) {
        char[] charArray = source.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            this.currentPosition = i;
            char c = charArray[i];



            if (this.isInState(TokenizerState.DIGIT)) {
                // Support 12l, 24f and close the modify
                if (this.getPostDigitLabelList().contains(c)) {
                    this.currentSession.appendCharacter(c);
                    this.changeState(TokenizerState.TRIALING_SPACE);
                    continue;
                }
                // Support 12.1
                if (c == '.') {
                    this.currentSession.appendCharacter(c);
                    this.changeState(TokenizerState.FLOAT);
                } else {
                    // If it is not 12f and 12.1, submit
                    this.submitSession();
                    i -= 1;
                }
                continue;
            }

            if (Character.isAlphabetic(c) || c == '_') {
                if (this.isInState(TokenizerState.LEADING_SPACE)) {
                    // start from leading
                    this.changeState(TokenizerState.TEXT);
                }
                if (this.isInState(TokenizerState.TEXT)) {
                    // append to existing session
                    this.currentSession.appendCharacter(c);
                    continue;
                }
                if (this.isInState(TokenizerState.TRIALING_SPACE) || this.isInState(TokenizerState.SPECIAL_SYMBOL)) {
                    // start a new session
                    this.submitSession();
                    i -= 1;
                    continue;
                }
            }

            if (Character.isDigit(c)) {
                if (this.isInState(TokenizerState.LEADING_SPACE)) {
                    // start from leading
                    this.changeState(TokenizerState.DIGIT);
                }
                if (this.isInState(TokenizerState.TEXT) || this.isInState(TokenizerState.DIGIT) || this.isInState(TokenizerState.FLOAT)) {
                    // support abc2, 1234, 123.45
                    this.currentSession.appendCharacter(c);
                    continue;
                }
                if (this.isInState(TokenizerState.TRIALING_SPACE) || this.isInState(TokenizerState.SPECIAL_SYMBOL)) {
                    // start new session
                    this.submitSession();
                    i -= 1;
                    continue;
                }
            }

            if (Character.isWhitespace(c)) {
                if (this.isInState(TokenizerState.LEADING_SPACE)) {
                    // continue leading
                    this.currentSession.appendLeadingSpace();
                    continue;
                }
                if (this.isInState(TokenizerState.TRIALING_SPACE)) {
                    // continue trialing
                    this.currentSession.appendTrialingSpace();
                    continue;
                }
                if (this.getChangeLineSymbols().contains(this.currentSession.getRawString())) {
                    // if current session is change line symbol, submit the session without trialing
                    this.submitSession();
                    i -= 1;
                    continue;
                }
                // other wise, change to trialing space
                this.changeState(TokenizerState.TRIALING_SPACE);
                i -= 1;
                continue;
            }

            if (this.isInState(TokenizerState.TRIALING_SPACE)) {
                // trialing meeting something, submit the current session
                this.submitSession();
                i -= 1;
                continue;
            }

            if (this.isInState(TokenizerState.LEADING_SPACE)) {
                // leading meet something, switch to special symbol
                this.currentSession.appendCharacter(c);
                this.changeState(TokenizerState.SPECIAL_SYMBOL);
                continue;
            }

            if (this.isInState(TokenizerState.SPECIAL_SYMBOL)) {
                if (this.isPartialSpecialToken(this.currentSession.getRawString() + c)) {
                    // if we can match a longer symbol, we match it. which means => will not be split to = >
                    this.currentSession.appendCharacter(c);
                } else {
                    // other wise, submit the current one. === will be split as == =.
                    this.submitSession();
                    i -= 1;
                }
                continue;
            }
        }
        if (!this.currentSession.getRawString().equals("")) {
            // if we meet the end of the string, we check if there is un-submitted token.
            this.submitSession();
        }
        return this.tokenList;
    }

    private enum TokenizerState {
        LEADING_SPACE,
        TRIALING_SPACE,
        TEXT,
        DIGIT,
        FLOAT,
        SPECIAL_SYMBOL
    }

    private class TokenizerSession {
        private StringBuilder stringBuilder = new StringBuilder();
        private int start = 0;
        private int end = 0;
        private int fullStart = 0;
        private int fullEnd = 0;

        TokenizerSession(int start, int fullStart) {
            initStart(start, fullStart);
            initEnd(start, fullStart);
        }

        private void initStart(int start, int fullStart) {
            this.start = start;
            this.fullStart = fullStart;
        }

        private void initEnd(int end, int fullEnd) {
            this.end = end;
            this.fullEnd = fullEnd;
        }

        void appendCharacter(char c) {
            this.stringBuilder.append(c);
            this.end += 1;
            this.fullEnd += 1;
        }

        void appendLeadingSpace() {
            this.start += 1;
            if (this.start > this.end) {
                this.end = this.start;
            }
            if (this.end > this.fullEnd) {
                this.fullEnd = this.end;
            }
        }

        void appendTrialingSpace() {
            this.fullEnd += 1;
        }

        String getRawString() {
            return this.stringBuilder.toString();
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

        int getFullStart() {
            return fullStart;
        }

        int getFullEnd() {
            return fullEnd;
        }

        SyntaxToken getToken() {
            return new SyntaxToken(this.getRawString(), getSyntaxFacts().getSyntaxKind(this.getRawString()), this.getStart(), this.getEnd(), this.getFullStart(), this.getFullEnd(), false, false);
        }

        void clear(int start, int fullStart) {
            this.initStart(start, fullStart);
            this.initEnd(start, fullStart);
            this.stringBuilder = new StringBuilder();
        }
    }
}
