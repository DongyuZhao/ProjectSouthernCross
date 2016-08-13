package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OrderKeywordToken extends SyntaxToken {
    public OrderKeywordToken() {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN);
    }

    public OrderKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, missing, unexpected);
    }

    public OrderKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public OrderKeywordToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, end, missing, unexpected);
    }

    public OrderKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public OrderKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public OrderKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public OrderKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }

    public OrderKeywordToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, end, missing, unexpected, parent);
    }

    public OrderKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public OrderKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ORDER_KEYWORD, TweetQlSyntaxKind.ORDER_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
