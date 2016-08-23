package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dy.Zhao on 2016/8/23.
 */
public class TweetQlSyntaxTokenFactory {
    private static TweetQlSyntaxFacts syntaxFacts = TweetQlSyntaxFacts.getInstance();

    public static List<? extends SyntaxToken> transformTokens(List<SyntaxToken> originTokenList) {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        if (originTokenList != null) {
            originTokenList.forEach(t -> {
                switch (t.getRawString()) {
                    case TweetQlTokenString.CREATE_KEYWORD:
                        result.add(new CreateKeywordToken());
                        break;
                    case TweetQlTokenString.SELECT_KEYWORD:
                        result.add(new SelectKeywordToken());
                        break;
                    case TweetQlTokenString.FROM_KEYWORD:
                        result.add(new FromKeywordToken());
                        break;
                    case TweetQlTokenString.WHERE_KEYWORD:
                        result.add(new WhereKeywordToken());
                        break;
                    case TweetQlTokenString.CONTAIN_KEYWORD:
                        result.add(new ContainKeywordToken());
                        break;
                    case TweetQlTokenString.LIKE_KEYWORD:
                        result.add(new LikeKeywordToken());
                        break;
                    case TweetQlTokenString.AND_KEYWORD:
                        result.add(new AndKeywordToken());
                        break;
                    case TweetQlTokenString.OR_KEYWORD:
                        result.add(new OrderKeywordToken());
                        break;
                    case TweetQlTokenString.NOT_KEYWORD:
                        result.add(new NotKeywordToken());
                        break;
                    case TweetQlTokenString.SKIP_KEYWORD:
                        result.add(new SkipKeywordToken());
                        break;
                    case TweetQlTokenString.WINDOW_KEYWORD:
                        result.add(new WindowKeywordToken());
                        break;
                    case TweetQlTokenString.AS_KEYWORD:
                        result.add(new AsKeywordToken());
                        break;
                    case TweetQlTokenString.BETWEEN_KEYWORD:
                        result.add(new BetweenKeywordToken());
                        break;
                    case TweetQlTokenString.ORDER_KEYWORD:
                        result.add(new OrderKeywordToken());
                        break;
                    case TweetQlTokenString.BY_KEYWORD:
                        result.add(new ByKeywordToken());
                        break;
                    case TweetQlTokenString.ASCEND_KEYWORD:
                        result.add(new AscendKeywordToken());
                        break;
                    case TweetQlTokenString.DESCEND_KEYWORD:
                        result.add(new DescendKeywordToken());
                        break;
                    case TweetQlTokenString.OPEN_PARENTHESES:
                        result.add(new OpenParenthesesToken());
                        break;
                    case TweetQlTokenString.CLOSE_PARENTHESES:
                        result.add(new CloseParenthesesToken());
                        break;
                    case TweetQlTokenString.OPEN_BRACKET:
                        result.add(new OpenBracketToken());
                        break;
                    case TweetQlTokenString.CLOSE_BRACKET:
                        result.add(new CloseBracketToken());
                        break;
                    case TweetQlTokenString.OPEN_BRACE:
                        result.add(new OpenBraceToken());
                        break;
                    case TweetQlTokenString.CLOSE_BRACE:
                        result.add(new CloseBraceToken());
                        break;
                    case TweetQlTokenString.COMMA:
                        result.add(new CommaToken());
                        break;
                    case TweetQlTokenString.DOT:
                        result.add(new DotToken());
                        break;
                    case TweetQlTokenString.COLON:
                        result.add(new ColonToken());
                        break;
                    case TweetQlTokenString.SEMICOLON:
                        result.add(new SemicolonToken());
                        break;
                    case TweetQlTokenString.EQUAL:
                        result.add(new EqualToken());
                        break;
                    case TweetQlTokenString.BIGGER:
                        result.add(new BiggerToken());
                        break;
                    case TweetQlTokenString.LESS:
                        result.add(new LessToken());
                        break;
                    case TweetQlTokenString.BIGGER_EQUAL:
                        result.add(new BiggerEqualToken());
                        break;
                    case TweetQlTokenString.LESS_EQUAL:
                        result.add(new LessEqualToken());
                        break;
                    case TweetQlTokenString.CRLF:
                        result.add(new CRLFToken());
                        break;
                    case TweetQlTokenString.LF:
                        result.add(new LFToken());
                        break;
                    case TweetQlTokenString.STAR:
                        result.add(new StarToken());
                        break;
                    default:
                        if (syntaxFacts.isLiteralString(t.getRawString())) {
                            result.add(new LiteralStringToken(t.getRawString()));
                        } else if (syntaxFacts.isValidIdentifier(t.getRawString())) {
                            result.add(new IdentifierToken(t.getRawString()));
                        } else {
                            result.add(new SyntaxToken(t.getRawString(), t.getKind()));
                        }
                        break;
                }
            });
        }
        return result;
    }
}
