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
public class LikeKeywordToken extends BinaryOperatorToken {
    public LikeKeywordToken() {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD);
    }

    public LikeKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, error);
    }

    public LikeKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, start, error);
    }

    public LikeKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, parent, error);
    }

    public LikeKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, parent, start, error);
    }
}
