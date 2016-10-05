package project.code_analysis.tweet_ql.syntax.tokens.trivia;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.TriviaToken;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/28.
 */

/**
 * A syntax token class holds "/*"
 */
public class SlashStarToken extends TriviaToken {
    public SlashStarToken() {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN);
    }

    public SlashStarToken(SyntaxError error) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, error);
    }

    public SlashStarToken(int start, SyntaxError error) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, start, error);
    }

    public SlashStarToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, parent, error);
    }

    public SlashStarToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.SLASH_STAR, TweetQlTokenKind.SLASH_STAR_TOKEN, parent, start, error);
    }
}
