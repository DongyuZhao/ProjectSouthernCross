package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;
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

    private SyntaxTokenizer(ISyntaxFacts syntaxFacts) {
        this.syntaxFacts = syntaxFacts;
    }

    public static SyntaxTokenizer create(ISyntaxFacts syntaxFacts) {
        return new SyntaxTokenizer(syntaxFacts);
    }

    private Set<String> getChangeLineSymbols() {
        return this.getSyntaxFacts().getChangeLineSymbols();
    }

    public ISyntaxFacts getSyntaxFacts() {
        return this.syntaxFacts;
    }

    private boolean isSpecialSymbol(char c) {
        return this.isSpecialSymbol("" + c);
    }

    private boolean isSpecialSymbol(String s) {
        return this.getSpecialSymbolList().contains(s);
    }

    private Set<String> getSpecialSymbolList() {
        return this.getSyntaxFacts().getSpecialSymbolList();
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

    public List<SyntaxToken> tokenize(String source) {
        char[] charArray = source.toCharArray();
        this.currentSession = new TokenizerSession(0, 0);
        for (int i = 0; i < charArray.length; i++) {
            this.currentPosition = i;
            char c = charArray[i];

            switch (this.currentState) {
                case LEADING_SPACE:
                    if (Character.isWhitespace(c)) {
                        this.currentSession.appendLeadingSpace();
                        continue;
                    } else if (Character.isAlphabetic(c) || c == '_') {
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
                    } else if (c == '"') {
                        this.changeState(TokenizerState.STRING);
                        this.currentSession.appendCharacter(c);
                    } else {
                        this.changeState(TokenizerState.SPECIAL_SYMBOL);
                        this.currentSession.appendCharacter(c);
                    }
                    continue;
                case DIGIT:
                    if (Character.isWhitespace(c)) {
                        this.changeState(TokenizerState.TRIALING_SPACE);
                        i = i - 1;
                    } else if ((this.currentSession.getRawString() + c).equals("0x")
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
                case TEXT:
                    if (Character.isWhitespace(c)) {
                        this.changeState(TokenizerState.TRIALING_SPACE);
                        i = i - 1;
                    } else if (c == '_' || Character.isAlphabetic(c) || Character.isDigit(c)) {
                        this.currentSession.appendCharacter(c);
                    } else {
                        this.submitSession();
                        i = i - 1;
                    }
                    continue;
                case SPECIAL_SYMBOL:
                    if (Character.isWhitespace(c)) {
                        if (this.syntaxFacts.isChangeLineSymbol(this.currentSession.getRawString())) {
                            this.submitSession();
                            i = i - 1;
                        } else {
                            this.changeState(TokenizerState.TRIALING_SPACE);
                            i = i - 1;
                        }
                    } else if (this.syntaxFacts.isSpecialSymbol(this.currentSession.getRawString() + c)) {
                        this.currentSession.appendCharacter(c);
                    } else {
                        this.submitSession();
                        i = i - 1;
                    }
                    continue;
                case TRIALING_SPACE:
                    if (Character.isWhitespace(c)) {
                        this.currentSession.appendTrialingSpace();
                        continue;
                    } else {
                        this.submitSession();
                        i = i - 1;
                    }
                    continue;
                case STRING:
                    if (c == '"') {
                        this.currentState = TokenizerState.TRIALING_SPACE;
                    }
                    this.currentSession.appendCharacter(c);
                    continue;
                default:

                    break;
            }
        }
        if (!this.currentSession.getRawString().equals("")) {
            // if we meet the end of the string, we check if there is un-submitted token.
            this.submitSession();
        }
        return this.tokenList;
    }

    private void changeState(TokenizerState newState) {
        this.currentState = newState;
    }

    private void submitSession() {
        this.tokenList.add(this.currentSession.toSyntaxToken());
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

    private enum TokenizerState {
        LEADING_SPACE,
        TRIALING_SPACE,
        TEXT,
        DIGIT,
        SPECIAL_SYMBOL,
        STRING,
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

        SyntaxToken toSyntaxToken() {
            return new SyntaxToken(getSyntaxFacts().getLanguage(), this.getRawString(), getSyntaxFacts().getSyntaxKind(this.getRawString()), this.getStart(), false, false);
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

        void clear(int start, int fullStart) {
            this.initStart(start, fullStart);
            this.initEnd(start, fullStart);
            this.stringBuilder = new StringBuilder();
        }
    }
}
