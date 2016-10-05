package project.code_analysis.tweet_ql.syntax.lexers;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;
import project.code_analysis.tweet_ql.syntax.tokens.TweetQlSyntaxToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The lexer of TweetQL
 */
public class TweetQlLexer {
    private State currentState = State.IDLE;
    private Stack<State> stateStack = new Stack<>();

    private TweetQlLexer() {

    }

    /**
     * Get new instance of TweetQlLexer
     *
     * @return the new instance of TweetQlLexer
     */
    public static TweetQlLexer create() {
        return new TweetQlLexer();
    }

    /**
     * Check the given token list and output a list with updated error info
     *
     * @param originTokenList the given token list
     * @return the token list with updated error info
     */
    public List<? extends SyntaxToken> lex(List<? extends SyntaxToken> originTokenList) {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        for (int i = 0; i < originTokenList.size(); i++) {
            SyntaxToken token = originTokenList.get(i);
            switch (this.currentState) {
                case IDLE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CREATE_KEYWORD:
                            this.enterScope(State.IN_CREATE);
                            result.add(token);
                            break;
                        case SELECT_KEYWORD:
                            this.enterScope(State.IN_SELECT);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case IN_CREATE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.changeState(State.AFTER_IDENTIFIER_IN_CREATE);
                            this.enterScope(State.IN_IDENTIFIER_IN_CREATE);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case IN_IDENTIFIER_IN_CREATE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case FROM_KEYWORD:
                            this.changeState(State.AFTER_FROM_IN_IDENTIFIER_IN_CREATE);
                            this.enterScope(State.IN_FROM);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER_IN_CREATE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.changeState(State.IN_CREATE);
                            result.add(token);
                            break;
                        case SEMICOLON_TOKEN:
                            this.leaveScope();
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_FROM_IN_IDENTIFIER_IN_CREATE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                        case SEMICOLON_TOKEN:
                            this.leaveScope();
                            i--;
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case IN_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.changeState(State.AFTER_IDENTIFIER_IN_SELECT);
                            result.add(token);
                            break;
                        case STAR_TOKEN:
                            this.changeState(State.AFTER_STAR_IN_SELECT);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER_IN_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.changeState(State.AFTER_COMMA_IN_IDENTIFIER_IN_SELECT);
                            result.add(token);
                            break;
                        case FROM_KEYWORD:
                            this.changeState(State.AFTER_FROM_IN_SELECT);
                            this.enterScope(State.IN_FROM);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_STAR_IN_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case FROM_KEYWORD:
                            this.changeState(State.AFTER_FROM_IN_SELECT);
                            this.enterScope(State.IN_FROM);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_COMMA_IN_IDENTIFIER_IN_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.changeState(State.AFTER_IDENTIFIER_IN_SELECT);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_FROM_IN_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.enterScope(State.IN_FROM);
                            result.add(token);
                            break;
                        case SEMICOLON_TOKEN:
                            this.leaveScope();
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case IN_FROM:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                        case STAR_TOKEN:
                            this.changeState(State.AFTER_IDENTIFIER_IN_FROM);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER_IN_FROM:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case WHERE_KEYWORD:
                            this.enterScope(State.IN_WHERE);
                            result.add(token);
                            break;
                        case SEMICOLON_TOKEN:
                        case COMMA_TOKEN:
                            this.leaveScope();
                            i--;
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case IN_WHERE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.changeState(State.AFTER_FIRST_IDENTIFIER);
                            result.add(token);
                            break;
                        case OPEN_PARENTHESES:
                            this.changeState(State.AFTER_SECOND_IDENTIFIER);
                            this.enterScope(State.IN_PARENTHESES_SCOPE);
                            result.add(token);
                            break;
                        default:
                            if (TweetQlSyntaxFacts.getInstance().isUnaryOperator(token.getRawString())) {
                                this.changeState(State.AFTER_SECOND_IDENTIFIER);
                                this.enterScope(State.IN_UNARY_EXPRESSION);
                                result.add(token);
                            } else {
                                token.setError(SyntaxError.getUnexpectedError(token));
                                result.add(token);
                            }
                            break;
                    }
                    break;
                case AFTER_FIRST_IDENTIFIER:
                    if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getRawString())) {
                        this.changeState(State.AFTER_BINARY_OPERATOR);
                        result.add(token);
                    } else {
                        token.setError(SyntaxError.getUnexpectedError(token));
                        result.add(token);
                    }
                    break;
                case AFTER_BINARY_OPERATOR:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case LITERAL_STRING_TOKEN:
                        case DIGIT_TOKEN:
                            this.changeState(State.AFTER_SECOND_IDENTIFIER);
                            result.add(token);
                            break;
                        case OPEN_PARENTHESES:
                            this.changeState(State.AFTER_SECOND_IDENTIFIER);
                            this.enterScope(State.IN_PARENTHESES_SCOPE);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_SECOND_IDENTIFIER:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                        case SEMICOLON_TOKEN:
                            this.leaveScope();
                            i--;
                            break;
                        default:
                            if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getRawString())) {
                                this.changeState(State.IN_WHERE);
                                result.add(token);
                            } else {
                                token.setError(SyntaxError.getUnexpectedError(token));
                                result.add(token);
                            }
                            break;
                    }
                    break;
                case AFTER_FIRST_IDENTIFIER_IN_SCOPE:
                    if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getRawString())) {
                        this.changeState(State.AFTER_BINARY_OPERATOR_IN_SCOPE);
                        result.add(token);
                    } else {
                        token.setError(SyntaxError.getUnexpectedError(token));
                        result.add(token);
                    }
                    break;
                case AFTER_BINARY_OPERATOR_IN_SCOPE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case LITERAL_STRING_TOKEN:
                        case DIGIT_TOKEN:
                            this.changeState(State.AFTER_SECOND_IDENTIFIER_IN_SCOPE);
                            result.add(token);
                            break;
                        case OPEN_PARENTHESES:
                            this.changeState(State.AFTER_SECOND_IDENTIFIER_IN_SCOPE);
                            this.enterScope(State.IN_PARENTHESES_SCOPE);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_SECOND_IDENTIFIER_IN_SCOPE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CLOSE_PARENTHESES:
                            this.leaveScope();
                            result.add(token);
                            break;
                        default:
                            if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getRawString())) {
                                this.changeState(State.IN_PARENTHESES_SCOPE);
                                result.add(token);
                            } else {
                                token.setError(SyntaxError.getUnexpectedError(token));
                                result.add(token);
                            }
                            break;
                    }
                    break;
                case IN_UNARY_EXPRESSION:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case OPEN_PARENTHESES:
                            this.changeState(State.AFTER_UNARY_BODY);
                            this.enterScope(State.IN_PARENTHESES_SCOPE);
                            result.add(token);
                            break;
                        default:
                            token.setError(SyntaxError.getUnexpectedError(token));
                            result.add(token);
                            break;
                    }
                    break;
                case AFTER_UNARY_BODY:
                    this.leaveScope();
                    i--;
                    break;
                case IN_PARENTHESES_SCOPE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.changeState(State.AFTER_FIRST_IDENTIFIER_IN_SCOPE);
                            result.add(token);
                            break;
                        case OPEN_PARENTHESES:
                            this.changeState(State.AFTER_SECOND_IDENTIFIER_IN_SCOPE);
                            this.enterScope(State.IN_PARENTHESES_SCOPE);
                            result.add(token);
                            break;
                        default:
                            if (TweetQlSyntaxFacts.getInstance().isUnaryOperator(token.getRawString())) {
                                this.changeState(State.AFTER_SECOND_IDENTIFIER_IN_SCOPE);
                                this.enterScope(State.IN_UNARY_EXPRESSION);
                                result.add(token);
                            } else {
                                token.setError(SyntaxError.getUnexpectedError(token));
                                result.add(token);
                            }
                            break;
                    }
                    break;
            }
        }
        if (this.currentState != State.IDLE) {
            result.add(new TweetQlSyntaxToken("", TweetQlTokenKind.UNDETERMINED_TOKEN, SyntaxError.getMissingError("")));
        }
        return result;
    }

    private void enterScope(State state) {
        this.stateStack.push(this.currentState);
        this.currentState = state;
    }

    private void changeState(State state) {
        this.currentState = state;
    }

    private void leaveScope() {
        if (this.stateStack.size() != 0) {
            this.currentState = this.stateStack.pop();
        }
    }

    private enum State {
        IDLE,
        IN_CREATE,
        IN_IDENTIFIER_IN_CREATE,
        AFTER_IDENTIFIER_IN_CREATE,
        AFTER_FROM_IN_IDENTIFIER_IN_CREATE,
        IN_SELECT,
        AFTER_IDENTIFIER_IN_SELECT,
        AFTER_STAR_IN_SELECT,
        AFTER_COMMA_IN_IDENTIFIER_IN_SELECT,
        AFTER_FROM_IN_SELECT,
        IN_FROM,
        AFTER_IDENTIFIER_IN_FROM,
        IN_WHERE,
        AFTER_FIRST_IDENTIFIER,
        AFTER_BINARY_OPERATOR,
        AFTER_SECOND_IDENTIFIER,
        AFTER_FIRST_IDENTIFIER_IN_SCOPE,
        AFTER_BINARY_OPERATOR_IN_SCOPE,
        AFTER_SECOND_IDENTIFIER_IN_SCOPE,
        IN_UNARY_EXPRESSION,
        AFTER_UNARY_BODY,
        IN_PARENTHESES_SCOPE,
    }
}
