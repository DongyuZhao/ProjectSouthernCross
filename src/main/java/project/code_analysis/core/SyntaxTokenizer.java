package project.code_analysis.core;

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

    private enum TokenizerState {
        LEADING_SPACE,
        TRIALING_SPACE,
        TEXT,
        DIGIT,
        SPECIAL_SYMBOL
    }

    public ArrayList<SyntaxToken> tokenize(String source) {
        char[] charArray = source.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            this.currentPosition = i;
            char c = charArray[i];

            if (this.isInState(TokenizerState.LEADING_SPACE)) {
                if (Character.isWhitespace(c)) {
                    this.currentSession.appendLeadingSpace();
                    continue;
                }
                else if (Character.isAlphabetic(c) || c == '_') {
                    this.changeState(TokenizerState.TEXT);
                    this.currentSession.appendCharacter(c);
                } else if (c == '-') {
                    if (charArray.length > i + 1 && Character.isDigit(charArray[i + 1])) {
                        this.changeState(TokenizerState.DIGIT);
                    } else {
                        this.changeState(TokenizerState.SPECIAL_SYMBOL);
                    }
                    this.currentSession.appendCharacter(c);
                } else if (Character.isDigit(c)) {
                    this.changeState(TokenizerState.DIGIT);
                    this.currentSession.appendCharacter(c);
                } else {
                    this.changeState(TokenizerState.SPECIAL_SYMBOL);
                    this.currentSession.appendCharacter(c);
                }
                continue;
            }

            if (this.isInState(TokenizerState.DIGIT)) {
                if (Character.isWhitespace(c)) {
                    this.changeState(TokenizerState.TRIALING_SPACE);
                    i = i - 1;
                }
                else if ((this.currentSession.getRawString() + c).equals("0x")
                        || (this.currentSession.getRawString() + c).equals("-0x")) {
                    this.currentSession.appendCharacter(c);
                } else {
                    if (this.syntaxFacts.isDigit((this.currentSession.getRawString() + c))) {
                        this.currentSession.appendCharacter(c);
                    } else {
                        this.submitSession();
                        i = i - 1;
                    }
                }
                continue;
            }

            if (this.isInState(TokenizerState.TEXT)) {
                if (Character.isWhitespace(c)) {
                    this.changeState(TokenizerState.TRIALING_SPACE);
                    i = i - 1;
                }
                else if (c == '_' || Character.isAlphabetic(c) || Character.isDigit(c)) {
                    this.currentSession.appendCharacter(c);
                } else {
                    this.submitSession();
                    i = i - 1;
                }
                continue;
            }

            if (this.isInState(TokenizerState.SPECIAL_SYMBOL)) {
                if (Character.isWhitespace(c)) {
                    if (this.syntaxFacts.isChangeLineSymbol(this.currentSession.getRawString())) {
                        i = i - 1;
                    } else {
                        this.changeState(TokenizerState.TRIALING_SPACE);
                        i = i - 1;
                    }
                }
                if (this.syntaxFacts.isSpecialSymbol(this.currentSession.getRawString() + c)) {
                    this.currentSession.appendCharacter(c);
                } else {
                    this.submitSession();
                    i = i - 1;
                }
                continue;
            }

            if (this.isInState(TokenizerState.TRIALING_SPACE)) {
                if (Character.isWhitespace(c)) {
                    this.currentSession.appendTrialingSpace();
                    continue;
                } else {
                    this.submitSession();
                    i = i - 1;
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
