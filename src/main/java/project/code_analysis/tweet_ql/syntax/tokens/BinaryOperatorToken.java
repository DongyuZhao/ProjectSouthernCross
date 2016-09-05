package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/5.
 */
public class BinaryOperatorToken extends TweetQlSyntaxToken {
    public BinaryOperatorToken(String rawString, ISyntaxKind kind) {
        super(rawString, kind);
    }

    public BinaryOperatorToken(String rawString, ISyntaxKind kind, SyntaxError error) {
        super(rawString, kind, error);
    }

    public BinaryOperatorToken(String rawString, ISyntaxKind kind, int start, SyntaxError error) {
        super(rawString, kind, start, error);
    }

    public BinaryOperatorToken(String rawString, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(rawString, kind, parent, error);
    }

    public BinaryOperatorToken(String rawString, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, kind, parent, start, error);
    }

    public static boolean isBinaryOperator(SyntaxToken token) {
        return token != null && BinaryOperatorToken.class.isAssignableFrom(token.getClass());
    }
}
