package project.code_analysis.tweet_ql.syntax.tokens.unary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.UnaryOperatorToken;

/**
 * A syntax token class holds "NOT"
 */
public class NotToken extends UnaryOperatorToken {
    public NotToken() {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD);
    }

    public NotToken(SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, error);
    }

    public NotToken(int start, SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, start, error);
    }

    public NotToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, parent, error);
    }

    public NotToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, parent, start, error);
    }
}
