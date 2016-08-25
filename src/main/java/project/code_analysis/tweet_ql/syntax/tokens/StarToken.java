package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StarToken extends TweetQlSyntaxToken {
    public StarToken() {
        super(TweetQlTokenString.STAR, TweetQlSyntaxTokenKind.STAR_TOKEN);
    }

    public StarToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxTokenKind.STAR_TOKEN, missing, unexpected);
    }

    public StarToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxTokenKind.STAR_TOKEN, start, missing, unexpected);
    }

    public StarToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxTokenKind.STAR_TOKEN, missing, unexpected, parent);
    }

    public StarToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxTokenKind.STAR_TOKEN, start, missing, unexpected, parent);
    }
}
