package project.code_analysis.tweet_ql.syntax.tokens.binary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

/**
 * A syntax token class holds bigger operator
 */
public class BiggerToken extends BinaryOperatorToken {
    public BiggerToken() {
        super(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN);
    }

    public BiggerToken(SyntaxError error) {
        super(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN, error);
    }

    public BiggerToken(int start, SyntaxError error) {
        super(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN, start, error);
    }

    public BiggerToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN, parent, error);
    }

    public BiggerToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.BIGGER, TweetQlTokenKind.BIGGER_TOKEN, parent, start, error);
    }
}
