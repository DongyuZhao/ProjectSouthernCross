package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/25.
 */
public class ConstValueSyntax extends EvaluableExpression {
    public ConstValueSyntax(ISyntaxKind kind) {
        super(kind);
    }

    public ConstValueSyntax(ISyntaxKind kind, SyntaxError error) {
        super(kind, error);
    }

    public ConstValueSyntax(ISyntaxKind kind, int start, SyntaxError error) {
        super(kind, start, error);
    }

    public ConstValueSyntax(ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(kind, parent, error);
    }

    public ConstValueSyntax(ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(kind, parent, start, error);
    }
}
