package project.code_analysis.tweet_ql.syntax.tokens.binary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

/**
 * A syntax token class holds "AND"
 */
public class AndToken extends BinaryOperatorToken {
    public AndToken() {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD);
    }

    public AndToken(SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, error);
    }

    public AndToken(int start, SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, start, error);
    }

    public AndToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, parent, error);
    }

    public AndToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, parent, start, error);
    }
}
