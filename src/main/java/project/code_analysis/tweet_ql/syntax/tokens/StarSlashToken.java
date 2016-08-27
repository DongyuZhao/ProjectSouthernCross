package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
 */
public class StarSlashToken extends TweetQlSyntaxToken {
    public StarSlashToken() {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN);
    }

    public StarSlashToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, missing, unexpected);
    }

    public StarSlashToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, start, missing, unexpected);
    }

    public StarSlashToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, parent, missing, unexpected);
    }

    public StarSlashToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, parent, start, missing, unexpected);
    }
}
