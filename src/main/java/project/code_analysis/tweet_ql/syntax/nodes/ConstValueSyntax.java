package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
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

    public ConstValueSyntax(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public ConstValueSyntax(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public ConstValueSyntax(ISyntaxKind kind, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(kind, parent, missing, unexpected);
    }

    public ConstValueSyntax(ISyntaxKind kind, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(kind, parent, start, missing, unexpected);
    }
}
