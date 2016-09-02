package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
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

    public StarSlashToken(SyntaxError error) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, error);
    }

    public StarSlashToken(int start, SyntaxError error) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, start, error);
    }

    public StarSlashToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, parent, error);
    }

    public StarSlashToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.STAR_SLASH, TweetQlTokenKind.STAR_SLASH_TOKEN, parent, start, error);
    }
}
