package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class EvaluableExpression extends TweetQlSyntaxNode {
    public EvaluableExpression(ISyntaxKind kind) {
        super(kind);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxError error) {
        super(kind, error);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, SyntaxError error) {
        super(kind, start, error);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(kind, parent, error);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(kind, parent, start, error);
    }

    public static boolean isEvaluable(SyntaxNode node) {
        return node != null && (node.getKind() == TweetQlNodeKind.BINARY_EXPRESSION || node.getKind() == TweetQlNodeKind.UNARY_EXPRESSION);
    }
}
