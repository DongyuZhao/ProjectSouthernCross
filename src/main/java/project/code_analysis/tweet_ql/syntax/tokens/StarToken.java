package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StarToken extends TweetQlSyntaxToken {
    public StarToken() {
        super(TweetQlTokenString.STAR, TweetQlTokenKind.STAR_TOKEN);
    }

    public StarToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlTokenKind.STAR_TOKEN, missing, unexpected);
    }

    public StarToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlTokenKind.STAR_TOKEN, start, missing, unexpected);
    }

    public StarToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlTokenKind.STAR_TOKEN, parent, missing, unexpected);
    }

    public StarToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlTokenKind.STAR_TOKEN, parent, start, missing, unexpected);
    }
}
