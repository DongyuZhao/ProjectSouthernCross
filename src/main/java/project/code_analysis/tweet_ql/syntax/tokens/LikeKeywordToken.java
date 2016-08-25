package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class LikeKeywordToken extends TweetQlSyntaxToken {
    public LikeKeywordToken() {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlSyntaxTokenKind.LIKE_KEYWORD_TOKEN);
    }

    public LikeKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlSyntaxTokenKind.LIKE_KEYWORD_TOKEN, missing, unexpected);
    }

    public LikeKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlSyntaxTokenKind.LIKE_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public LikeKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlSyntaxTokenKind.LIKE_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public LikeKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlSyntaxTokenKind.LIKE_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
