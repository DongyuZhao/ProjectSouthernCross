package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.syntax.tokens.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class SyntaxLexer {
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

        IN_SCOPE,
        AFTER_FIRST_IDENTIFIER_IN_BINARY,
        AFTER_OPERATOR_IN_BINARY,
        AFTER_SECOND_IDENTIFIER_IN_BINARY,
        AFTER_UNIVERSE_IN_SELECT,
        AFTER_UNIVERSE_IN_FROM,
        AFTER_NOT,
        AFTER_OPEN_PARENTHESES,
        AFTER_CLOSE_PARENTHESES,
    }

    private LexerStates currentState = LexerStates.IDLE;
    private Stack<LexerStates> scopeLexStack = new Stack<>();
    private TweetQlSyntaxFacts syntaxFacts = new TweetQlSyntaxFacts();

    public List<? extends SyntaxToken> transformTokens(List<SyntaxToken> originTokenList) {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        if (originTokenList != null) {
            originTokenList.forEach(t -> {
                switch ((TweetQlSyntaxKind) t.getKind()) {
                    case CREATE_KEYWORD_TOKEN:
                        result.add(new CreateKeywordToken());
                        break;
                    case SELECT_KEYWORD_TOKEN:
                        result.add(new SelectKeywordToken());
                        break;
                    case FROM_KEYWORD_TOKEN:
                        result.add(new FromKeywordToken());
                        break;
                    case WHERE_KEYWORD_TOKEN:
                        result.add(new WhereKeywordToken());
                        break;
                    case CONTAIN_KEYWORD_TOKEN:
                        result.add(new ContainKeywordToken());
                        break;
                    case LIKE_KEYWORD_TOKEN:
                        result.add(new LikeKeywordToken());
                        break;
                    case AND_KEYWORD_TOKEN:
                        result.add(new AndKeywordToken());
                        break;
                    case OR_KEYWORD_TOKEN:
                        result.add(new OrderKeywordToken());
                        break;
                    case NOT_KEYWORD_TOKEN:
                        result.add(new NotKeywordToken());
                        break;
                    case SKIP_KEYWORD_TOKEN:
                        result.add(new SkipKeywordToken());
                        break;
                    case WINDOW_KEYWORD_TOKEN:
                        result.add(new WindowKeywordToken());
                        break;
                    case AS_KEYWORD_TOKEN:
                        result.add(new AsKeywordToken());
                        break;
                    case BETWEEN_KEYWORD_TOKEN:
                        result.add(new BetweenKeywordToken());
                        break;
                    case ORDER_KEYWORD_TOKEN:
                        result.add(new OrderKeywordToken());
                        break;
                    case BY_KEYWORD_TOKEN:
                        result.add(new ByKeywordToken());
                        break;
                    case ASCEND_KEYWORD_TOKEN:
                        result.add(new AscendKeywordToken());
                        break;
                    case DESCEND_KEYWORD_TOKEN:
                        result.add(new DescendKeywordToken());
                        break;
                    case OPEN_PARENTHESES_TOKEN:
                        result.add(new OpenParenthesesToken());
                        break;
                    case CLOSE_PARENTHESES_TOKEN:
                        result.add(new CloseParenthesesToken());
                        break;
                    case OPEN_BRACKET_TOKEN:
                        result.add(new OpenBracketToken());
                        break;
                    case CLOSE_BRACKET_TOKEN:
                        result.add(new CloseBracketToken());
                        break;
                    case OPEN_BRACE_TOKEN:
                        result.add(new OpenBraceToken());
                        break;
                    case CLOSE_BRACE_TOKEN:
                        result.add(new CloseBraceToken());
                        break;
                    case COMMA_TOKEN:
                        result.add(new CommaToken());
                        break;
                    case DOT_TOKEN:
                        result.add(new DotToken());
                        break;
                    case COLON_TOKEN:
                        result.add(new ColonToken());
                        break;
                    case SEMICOLON_TOKEN:
                        result.add(new SemicolonToken());
                        break;
                    case EQUAL_TOKEN:
                        result.add(new EqualToken());
                        break;
                    case BIGGER_TOKEN:
                        result.add(new BiggerToken());
                        break;
                    case LESS_TOKEN:
                        result.add(new LessToken());
                        break;
                    case BIGGER_EQUAL_TOKEN:
                        result.add(new BiggerEqualToken());
                        break;
                    case LESS_EQUAL_TOKEN:
                        result.add(new LessEqualToken());
                        break;
                    case CRLF_TOKEN:
                        result.add(new CRLFToken());
                        break;
                    case LF_TOKEN:
                        result.add(new LFToken());
                        break;
                    case IDENTIFIER_TOKEN:
                        result.add(new IdentifierToken(t.getRawString()));
                        break;
                    default:
                        result.add(new SyntaxToken(t.getRawString(), t.getKind()));
                        break;
                }
            });
        }
        return result;
    }

    public List<? extends SyntaxToken> lex(List<? extends SyntaxToken> originTokenList) {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        for (int i = 0; i < originTokenList.size(); i++) {
            SyntaxToken token = originTokenList.get(i);
            if (token.getKind() == TweetQlSyntaxKind.CRLF_TOKEN || token.getKind() == TweetQlSyntaxKind.LF_TOKEN) {
                continue;
            }

            if (this.currentState == LexerStates.IDLE) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case CREATE_KEYWORD_TOKEN:
                        this.currentState = LexerStates.AFTER_CREATE;
                        break;
                    case SELECT_KEYWORD_TOKEN:
                        this.currentState = LexerStates.AFTER_SELECT;
                    default:
                        token.setError(false, true);
                        break;
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_CREATE || this.currentState == LexerStates.AFTER_COMMA_IN_CREATE) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case IDENTIFIER_TOKEN:
                        this.currentState = LexerStates.AFTER_IDENTIFIER_IN_CREATE;
                        break;
                    default:
                        if (originTokenList.size() > i + 1) {
                            if (originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.IDENTIFIER_TOKEN) {
                                token.setError(false, true);
                            } else {
                                result.add(new IdentifierToken("", true, false));
                                i = i - 1;
                                this.currentState = LexerStates.AFTER_IDENTIFIER_IN_CREATE;
                                continue;
                            }
                        }
                        break;
                }
                this.currentState = LexerStates.AFTER_IDENTIFIER_IN_CREATE;
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_SELECT || this.currentState == LexerStates.AFTER_COMMA_IN_SELECT) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case IDENTIFIER_TOKEN:
                        this.currentState = LexerStates.AFTER_IDENTIFIER_IN_SELECT;
                        break;
                    case STAR_TOKEN:
                        this.currentState = LexerStates.AFTER_UNIVERSE_IN_SELECT;
                        break;
                    default:
                        if (originTokenList.size() > i + 1) {
                            if (originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.IDENTIFIER_TOKEN) {
                                token.setError(false, true);
                            } else {
                                result.add(new IdentifierToken("", true, false));
                                i = i - 1;
                                this.currentState = LexerStates.AFTER_IDENTIFIER_IN_SELECT;
                                continue;
                            }
                        }
                        break;
                }
                this.currentState = LexerStates.AFTER_IDENTIFIER_IN_SELECT;
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_IDENTIFIER_IN_CREATE
                    || this.currentState == LexerStates.AFTER_IDENTIFIER_IN_SELECT
                    || this.currentState == LexerStates.AFTER_UNIVERSE_IN_SELECT) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case COMMA_TOKEN:
                        if (this.currentState == LexerStates.AFTER_UNIVERSE_IN_SELECT) {
                            token.setError(false, true);
                        }
                        if (this.currentState == LexerStates.AFTER_IDENTIFIER_IN_CREATE) {
                            this.currentState = LexerStates.AFTER_COMMA_IN_CREATE;
                        } else {
                            this.currentState = LexerStates.AFTER_COMMA_IN_SELECT;
                        }
                        break;
                    case FROM_KEYWORD_TOKEN:
                        this.currentState = LexerStates.AFTER_FROM;
                        break;
                    default:
                        if (originTokenList.size() > i + 1) {
                            if (originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.COMMA_TOKEN ||
                                    originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.FROM_KEYWORD_TOKEN) {
                                token.setError(false, true);
                            } else {
                                result.add(new FromKeywordToken(true, false));
                                i = i - 1;
                                this.currentState = LexerStates.AFTER_FROM;
                                continue;
                            }
                        }
                        break;
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_FROM) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case IDENTIFIER_TOKEN:
                        this.currentState = LexerStates.AFTER_IDENTIFIER_IN_FROM;
                        break;
                    case STAR_TOKEN:
                        this.currentState = LexerStates.AFTER_UNIVERSE_IN_FROM;
                        break;
                    default:
                        if (originTokenList.size() > i + 1) {
                            if (originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.IDENTIFIER_TOKEN) {
                                token.setError(false, true);
                            } else {
                                result.add(new IdentifierToken("", true, false));
                                i = i - 1;
                                this.currentState = LexerStates.AFTER_IDENTIFIER_IN_FROM;
                                continue;
                            }
                        }
                        break;
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_IDENTIFIER_IN_FROM) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case WHERE_KEYWORD_TOKEN:
                        this.currentState = LexerStates.IN_SCOPE;
                        break;
                    case SEMICOLON_TOKEN:
                        this.currentState = LexerStates.IDLE;
                        break;
                    default:
                        if (originTokenList.size() > i + 1) {
                            if (originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN ||
                                    originTokenList.get(i + 1).getKind() == TweetQlSyntaxKind.SEMICOLON_TOKEN) {
                                token.setError(false, true);
                            } else {
                                result.add(new SemicolonToken(true, false));
                                i = i - 1;
                                this.currentState = LexerStates.IDLE;
                                continue;
                            }
                        }
                        break;
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_UNIVERSE_IN_FROM) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case SEMICOLON_TOKEN:
                        this.currentState = LexerStates.IDLE;
                        break;
                    default:
                        token.setError(false, true);
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.IN_SCOPE) {
                switch ((TweetQlSyntaxKind) token.getKind()) {
                    case OPEN_PARENTHESES_TOKEN:
                        this.scopeLexStack.push(LexerStates.AFTER_FIRST_IDENTIFIER_IN_BINARY);
                        break;
                    case IDENTIFIER_TOKEN:
                        this.currentState = LexerStates.AFTER_FIRST_IDENTIFIER_IN_BINARY;
                        break;
                    case NOT_KEYWORD_TOKEN:
                        this.currentState = LexerStates.AFTER_NOT;
                        break;
                    default:
                        token.setError(false, true);
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_FIRST_IDENTIFIER_IN_BINARY) {
                if (syntaxFacts.isBinaryOperator(token.getKind())) {
                    this.currentState = LexerStates.AFTER_OPERATOR_IN_BINARY;
                } else {
                    token.setError(false, true);
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_OPERATOR_IN_BINARY) {
                switch ((TweetQlSyntaxKind)token.getKind()) {
                    case IDENTIFIER_TOKEN:
                        this.currentState = LexerStates.AFTER_SECOND_IDENTIFIER_IN_BINARY;
                        break;
                    case OPEN_PARENTHESES_TOKEN:
                        this.currentState = LexerStates.IN_SCOPE;
                        this.scopeLexStack.push(LexerStates.AFTER_SECOND_IDENTIFIER_IN_BINARY);
                        break;
                    default:
                        token.setError(false, true);
                }
                result.add(token);
                continue;
            }

            if (this.currentState == LexerStates.AFTER_SECOND_IDENTIFIER_IN_BINARY) {
                if (token.getKind() == TweetQlSyntaxKind.CLOSE_PARENTHESES_TOKEN) {
                    this.currentState = this.scopeLexStack.pop();
                } else if (syntaxFacts.isBinaryOperator(token.getKind())) {
                    this.currentState = LexerStates.IN_SCOPE;
                } else if (token.getKind() == TweetQlSyntaxKind.SEMICOLON_TOKEN) {
                    this.currentState = LexerStates.IDLE;
                } else {
                    token.setError(false, true);
                }
                result.add(token);
                continue;
            }

            result.add(token);
        }
        return result;
    }
}
