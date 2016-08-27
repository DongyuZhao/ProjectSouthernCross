package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class LikeKeywordToken extends TweetQlSyntaxToken {
    public LikeKeywordToken() {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD);
    }

    public LikeKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, missing, unexpected);
    }

    public LikeKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, start, missing, unexpected);
    }

    public LikeKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, parent, missing, unexpected);
    }

    public LikeKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, parent, start, missing, unexpected);
    }
}
