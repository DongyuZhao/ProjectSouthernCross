package project.code_analysis.tweet_ql.syntax.tokens.data;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * A syntax token class holds "*"
 */
public class StarToken extends IdentifierToken {
    public StarToken() {
        super(TweetQlTokenString.STAR);
        this.setKind(TweetQlTokenKind.STAR_TOKEN);
    }

    public StarToken(SyntaxError error) {
        super(TweetQlTokenString.STAR, error);
        this.setKind(TweetQlTokenKind.STAR_TOKEN);
    }

    public StarToken(int start, SyntaxError error) {
        super(TweetQlTokenString.STAR, start, error);
        this.setKind(TweetQlTokenKind.STAR_TOKEN);
    }

    public StarToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.STAR, parent, error);
        this.setKind(TweetQlTokenKind.STAR_TOKEN);
    }

    public StarToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.STAR, parent, start, error);
        this.setKind(TweetQlTokenKind.STAR_TOKEN);
    }
}
