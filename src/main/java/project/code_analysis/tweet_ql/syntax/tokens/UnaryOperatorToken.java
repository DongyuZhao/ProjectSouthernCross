package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;

/**
 * A common parent of all of the unary operators in TweetQL
 */
public class UnaryOperatorToken extends TweetQlSyntaxToken {
    public UnaryOperatorToken(String rawString, ISyntaxKind kind) {
        super(rawString, kind);
    }

    public UnaryOperatorToken(String rawString, ISyntaxKind kind, SyntaxError error) {
        super(rawString, kind, error);
    }

    public UnaryOperatorToken(String rawString, ISyntaxKind kind, int start, SyntaxError error) {
        super(rawString, kind, start, error);
    }

    public UnaryOperatorToken(String rawString, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(rawString, kind, parent, error);
    }

    public UnaryOperatorToken(String rawString, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, kind, parent, start, error);
    }

    public static boolean isUnaryOperator(SyntaxToken token) {
        return token != null && UnaryOperatorToken.class.isAssignableFrom(token.getClass());
    }
}
