package project.code_analysis.tweet_ql.syntax.tokens.binary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

/**
 * A syntax token class holds "CONTAIN"
 */
public class ContainToken extends BinaryOperatorToken {
    public ContainToken() {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD);
    }

    public ContainToken(SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, error);
    }

    public ContainToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, start, error);
    }

    public ContainToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, parent, error);
    }

    public ContainToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, parent, start, error);
    }
}
