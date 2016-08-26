package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OrderKeywordToken extends TweetQlSyntaxToken {
    public OrderKeywordToken() {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxTokenKind.ORDER_KEYWORD_TOKEN);
    }

    public OrderKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxTokenKind.ORDER_KEYWORD_TOKEN, missing, unexpected);
    }

    public OrderKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxTokenKind.ORDER_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public OrderKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxTokenKind.ORDER_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public OrderKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxTokenKind.ORDER_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
