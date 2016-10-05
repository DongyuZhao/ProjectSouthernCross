package project.code_analysis.tweet_ql.syntax.tokens.binary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */

/**
 * A syntax token class holds "LIKE"
 */
public class LikeToken extends BinaryOperatorToken {
    public LikeToken() {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD);
    }

    public LikeToken(SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, error);
    }

    public LikeToken(int start, SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, start, error);
    }

    public LikeToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, parent, error);
    }

    public LikeToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.LIKE_KEYWORD, TweetQlTokenKind.LIKE_KEYWORD, parent, start, error);
    }
}
