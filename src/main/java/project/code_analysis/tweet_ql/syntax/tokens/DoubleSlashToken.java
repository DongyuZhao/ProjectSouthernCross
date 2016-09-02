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
public class DoubleSlashToken extends TweetQlSyntaxToken {
    public DoubleSlashToken() {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN);
    }

    public DoubleSlashToken(SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, error);
    }

    public DoubleSlashToken(int start, SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, start, error);
    }

    public DoubleSlashToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, parent, error);
    }

    public DoubleSlashToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, parent, start, error);
    }
}
