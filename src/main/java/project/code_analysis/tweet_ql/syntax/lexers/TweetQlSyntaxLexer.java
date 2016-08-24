package project.code_analysis.tweet_ql.syntax.lexers;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class TweetQlSyntaxLexer {
    private LexerStates currentState = LexerStates.IDLE;
    private Stack<LexerStates> scopeLexStack = new Stack<>();
    private TweetQlSyntaxFacts syntaxFacts = TweetQlSyntaxFacts.getInstance();

    private TweetQlSyntaxLexer() {
    }

    public static TweetQlSyntaxLexer create() {
        return new TweetQlSyntaxLexer();
    }

    public List<? extends SyntaxToken> lex(List<? extends SyntaxToken> originTokenList) {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        for (SyntaxToken token : originTokenList) {
            switch (this.currentState) {
                case IDLE:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case CREATE_KEYWORD_TOKEN:
                            this.currentState = LexerStates.AFTER_CREATE;
                            result.add(token);
                            break;
                        case SELECT_KEYWORD_TOKEN:
                            this.currentState = LexerStates.AFTER_SELECT;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_CREATE:
                case AFTER_COMMA_IN_CREATE:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = LexerStates.AFTER_IDENTIFIER_IN_CREATE;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_SELECT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = LexerStates.AFTER_IDENTIFIER_IN_SELECT;
                            result.add(token);
                            break;
                        case STAR_TOKEN:
                            this.currentState = LexerStates.AFTER_STAR_IN_SELECT;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_IDENTIFIER_IN_CREATE:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = LexerStates.AFTER_COMMA_IN_CREATE;
                            result.add(token);
                            break;
                        case FROM_KEYWORD_TOKEN:
                            this.currentState = LexerStates.AFTER_FROM;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_IDENTIFIER_IN_SELECT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = LexerStates.AFTER_COMMA_IN_SELECT;
                            result.add(token);
                            break;
                        case FROM_KEYWORD_TOKEN:
                            this.currentState = LexerStates.AFTER_FROM;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_STAR_IN_SELECT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case FROM_KEYWORD_TOKEN:
                            this.currentState = LexerStates.AFTER_FROM;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_COMMA_IN_SELECT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = LexerStates.AFTER_IDENTIFIER_IN_SELECT;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_FROM:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                        case STAR_TOKEN:
                            this.currentState = LexerStates.AFTER_IDENTIFIER_IN_FROM;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_IDENTIFIER_IN_FROM:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case WHERE_KEYWORD_TOKEN:
                            this.currentState = LexerStates.AFTER_WHERE;
                            result.add(token);
                            break;
                        case SEMICOLON_TOKEN:
                            this.currentState = LexerStates.IDLE;
                            result.add(token);
                            break;
                        case COMMA_TOKEN:
                            this.currentState = LexerStates.AFTER_FROM;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_WHERE:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = LexerStates.AFTER_FIRST_IDENTIFIER_IN_BINARY;
                            result.add(token);
                            break;
                        default:
                            token.setError(false, true);
                            result.add(token);
                            break;
                    }
                    continue;
                case AFTER_FIRST_IDENTIFIER_IN_BINARY:
                    if (this.syntaxFacts.isBinaryOperator(token.getRawString())) {
                        this.currentState = LexerStates.AFTER_OPERATOR_IN_BINARY;
                        result.add(token);
                    } else {
                        token.setError(false, true);
                        result.add(token);
                    }
                    continue;
                case AFTER_OPERATOR_IN_BINARY:
                    if (this.syntaxFacts.isLiteralString(token.getRawString()) || this.syntaxFacts.isDigit(token.getRawString())) {
                        this.currentState = LexerStates.AFTER_SECOND_IDENTIFIER_IN_BINARY;
                        result.add(token);
                    } else {
                        token.setError(false, true);
                        result.add(token);
                    }
                    continue;
                case AFTER_SECOND_IDENTIFIER_IN_BINARY:
                    if (token.getKind() == TweetQlSyntaxTokenKind.SEMICOLON_TOKEN) {
                        this.currentState = LexerStates.IDLE;
                        result.add(token);
                    } else if (token.getKind() == TweetQlSyntaxTokenKind.COMMA_TOKEN) {
                        this.currentState = LexerStates.AFTER_FROM;
                        result.add(token);
                    } else if (this.syntaxFacts.isBinaryOperator(token.getRawString())) {
                        this.currentState = LexerStates.AFTER_WHERE;
                        result.add(token);
                    } else {
                        token.setError(false, true);
                        result.add(token);
                    }
                    continue;
                case AFTER_UNARY_OPERATOR:
                    break;
                case AFTER_OPEN_PARENTHESES:
                    break;
                case AFTER_CLOSE_PARENTHESES:
                    break;
                default:
                    token.setError(false, true);
                    result.add(token);
                    continue;
            }
        }
        return result;
    }

    private enum LexerStates {
        IDLE,
        AFTER_CREATE,
        AFTER_IDENTIFIER_IN_CREATE,
        AFTER_COMMA_IN_CREATE,

        AFTER_SELECT,
        AFTER_IDENTIFIER_IN_SELECT,
        AFTER_COMMA_IN_SELECT,

        AFTER_FROM,
        AFTER_IDENTIFIER_IN_FROM,

        AFTER_WHERE,
        AFTER_FIRST_IDENTIFIER_IN_BINARY,
        AFTER_OPERATOR_IN_BINARY,
        AFTER_SECOND_IDENTIFIER_IN_BINARY,
        AFTER_UNARY_OPERATOR,
        AFTER_OPEN_PARENTHESES,
        AFTER_CLOSE_PARENTHESES,
        AFTER_STAR_IN_SELECT
    }

}
