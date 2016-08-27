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
public class SlashStarToken extends TweetQlSyntaxToken {
    public SlashStarToken() {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN);
    }

    public SlashStarToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, missing, unexpected);
    }

    public SlashStarToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, start, missing, unexpected);
    }

    public SlashStarToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, parent, missing, unexpected);
    }

    public SlashStarToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, parent, start, missing, unexpected);
    }
}
