package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public abstract class AbstractTokenizer {
    private Session currentSession = new Session();
    private ISyntaxFactory syntaxFactory;
    private ISyntaxFacts syntaxFacts;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private State currentState = State.IDLE;

    protected AbstractTokenizer(ISyntaxFacts syntaxFacts, ISyntaxFactory syntaxFactory) {
        this.syntaxFactory = syntaxFactory;
        this.syntaxFacts = syntaxFacts;
    }

    public List<SyntaxToken> tokenize(String code) {
        this.tokenList.clear();
        char[] charArray = code.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (this.currentState) {
                case IDLE:
                    if (Character.isWhitespace(c)) {
                        this.changeState(State.WHITE_SPACE);
                        this.currentSession.append(c);
                    } else if (Character.isAlphabetic(c) || c == '_') {
                        this.changeState(State.TEXT);
                        this.currentSession.append(c);
                    } else if (c == '-') {
                        if (charArray.length > i + 1 && Character.isDigit(i + 1)) {
                            this.changeState(State.DIGIT);
                        } else {
                            this.changeState(State.SPECIAL_SYMBOL);
                        }
                        this.currentSession.append(c);
                    } else if (Character.isDigit(c)) {
                        this.changeState(State.DIGIT);
                        this.currentSession.append(c);
                    } else if (c == '"') {
                        this.changeState(State.STRING);
                        this.currentSession.append(c);
                    } else {
                        this.changeState(State.SPECIAL_SYMBOL);
                        this.currentSession.append(c);
                    }
                    break;
                case WHITE_SPACE:
                    if (Character.isWhitespace(c)) {
                        this.currentSession.append(c);
                    } else {
                        this.submitSession();
                        i--;
                    }
                    break;
                case TEXT:
                    if (this.syntaxFacts.isValidIdentifier(this.currentSession.peek() + c)) {
                        this.currentSession.append(c);
                    } else {
                        this.submitSession();
                        i--;
                    }
                    break;
                case DIGIT:
                    if ((this.currentSession.peek() + c).equals("0x") || (this.currentSession.peek() + c).equals("-0x")) {
                        this.currentSession.append(c);
                    } else if (this.syntaxFacts.isDigit((this.currentSession.peek() + c))) {
                        this.currentSession.append(c);
                    } else {
                        this.submitSession();
                        i--;
                    }
                    break;
                case SPECIAL_SYMBOL:
                    if (this.syntaxFacts.isSpecialSymbol(this.currentSession.peek() + c)) {
                        this.currentSession.append(c);
                    } else {
                        this.submitSession();
                        i--;
                    }
                    break;
                case STRING:
                    if (c != '"') {
                        this.currentSession.append(c);
                    } else {
                        this.currentSession.append(c);
                        this.submitSession();
                    }
                    break;
            }
        }
        if (this.currentState != State.IDLE) {
            this.submitSession();
        }
        return this.syntaxFactory.bindSyntaxTrivia(this.tokenList);
    }

    private void changeState(State state) {
        this.currentState = state;
    }

    private void submitSession() {
        this.tokenList.add(this.currentSession.getToken());
        this.currentState = State.IDLE;
    }

    private enum State {
        IDLE,
        WHITE_SPACE,
        TEXT,
        DIGIT,
        SPECIAL_SYMBOL,
        STRING,
    }

    private class Session {
        StringBuilder builder = new StringBuilder();

        public void append(char c) {
            if (this.builder == null) {
                this.builder = new StringBuilder();
            }
            this.builder.append(c);
        }

        public SyntaxToken getToken() {
            String rawString = this.builder.toString();
            this.builder = new StringBuilder();
            return syntaxFactory.buildToken(rawString);
        }

        public String peek() {
            return this.builder.toString();
        }
    }
}
