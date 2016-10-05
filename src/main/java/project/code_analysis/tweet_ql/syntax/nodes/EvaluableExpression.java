package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;

/**
 * A common parent of all of the evaluable expressions in TweetQL
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
        return node != null && EvaluableExpression.class.isAssignableFrom(node.getClass());
    }
}
