package project.code_analysis.tweet_ql.syntax.tokens.binary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

/**
 * A syntax token class holds "EQUAL"
 */
public class EqualToken extends BinaryOperatorToken {
    public EqualToken() {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN);
    }

    public EqualToken(SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, error);
    }

    public EqualToken(int start, SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, start, error);
    }

    public EqualToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, parent, error);
    }

    public EqualToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, parent, start, error);
    }
}
