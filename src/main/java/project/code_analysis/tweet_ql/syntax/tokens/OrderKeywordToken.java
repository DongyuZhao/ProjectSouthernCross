package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OrderKeywordToken extends TweetQlSyntaxToken {
    public OrderKeywordToken() {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlTokenKind.ORDER_KEYWORD);
    }

    public OrderKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlTokenKind.ORDER_KEYWORD, error);
    }

    public OrderKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlTokenKind.ORDER_KEYWORD, start, error);
    }

    public OrderKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlTokenKind.ORDER_KEYWORD, parent, error);
    }

    public OrderKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlTokenKind.ORDER_KEYWORD, parent, start, error);
    }
}
