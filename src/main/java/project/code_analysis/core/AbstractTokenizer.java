package project.code_analysis.core;

import java.util.ArrayList;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public abstract class AbstractTokenizer {
    protected Session currentSession = new Session();
    private ISyntaxFactory syntaxFactory;
    private ISyntaxFacts syntaxFacts;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private TokenizerStates currentState = TokenizerStates.IDLE;

    protected AbstractTokenizer(ISyntaxFactory syntaxFactory, ISyntaxFacts syntaxFacts) {
        this.syntaxFactory = syntaxFactory;
        this.syntaxFacts = syntaxFacts;
    }

    protected void submitSession() {
        this.tokenList.add(this.currentSession.getToken());
        this.currentState = TokenizerStates.IDLE;
    }

    public ArrayList<SyntaxToken> tokenize(String code) {
        char[] charArray = code.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (this.currentState) {
                case IDLE:
                    if (Character.isWhitespace(c)) {
                        this.currentState = TokenizerStates.LEADING_SPACE;
                        this.currentSession.append(c);
                        continue;
                    } else if (Character.isAlphabetic(c) || c == '_') {
                        this.currentState = TokenizerStates.TEXT;
                        this.currentSession.append(c);
                    } else if (c == '-') {
                        if (charArray.length > i + 1 && Character.isDigit(charArray[i + 1])) {
                            this.currentState = TokenizerStates.DIGIT;
                        } else {
                            this.currentState = TokenizerStates.SPECIAL_SYMBOL;
                        }
                        this.currentSession.append(c);
                    } else if (Character.isDigit(c)) {
                        this.currentState = TokenizerStates.DIGIT;
                        this.currentSession.append(c);
                    } else if (c == '"') {
                        this.currentState = TokenizerStates.STRING;
                        this.currentSession.append(c);
                    } else {
                        this.currentState = TokenizerStates.SPECIAL_SYMBOL;
                        this.currentSession.append(c);
                    }
                    break;
                case LEADING_SPACE:
                    break;
                case TRAILING_SPACE:
                    break;
                case LINE_COMMENTS:
                    break;
                case BLOCK_COMMENTS:
                    break;
                case TEXT:
                    break;
                case DIGIT:
                    break;
                case SPECIAL_SYMBOL:
                    break;
                case STRING:
                    break;
            }
        }
        return this.tokenList;
    }

    protected enum TokenizerStates {
        IDLE,
        LEADING_SPACE,
        TRAILING_SPACE,
        LINE_COMMENTS,
        BLOCK_COMMENTS,
        TEXT,
        DIGIT,
        SPECIAL_SYMBOL,
        STRING,
    }

    protected class Session {
        private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
        private SyntaxToken token;
        private StringBuilder builder = new StringBuilder();

        public void append(String s) {
            this.builder.append(s);
        }

        public void append(char c) {
            this.builder.append(c);
        }

        public void terminateSyntaxToken() {
            SyntaxToken token = syntaxFactory.buildToken(this.builder.toString());
            if (token != null) {
                this.token = token;
                this.leadingTrivia.forEach(token::addLeadingTrivia);
            }
        }

        public void terminateTrivia() {
            SyntaxTrivia trivia = syntaxFactory.buildTrivia(this.builder.toString());
            if (trivia != null) {
                if (this.token == null) {
                    this.leadingTrivia.add(trivia);
                } else {
                    this.token.addTrialingTrivia(trivia);
                }
            }
        }

        public SyntaxToken getToken() {
            SyntaxToken result = this.token;
            this.clear();
            return result;
        }

        public void clear() {
            this.token = null;
            this.leadingTrivia.clear();
            this.builder = new StringBuilder();
        }
    }
}
