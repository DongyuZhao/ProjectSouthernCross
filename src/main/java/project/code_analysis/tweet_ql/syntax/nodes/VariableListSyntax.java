package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxNode;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/23.
 */
public class VariableListSyntax extends TweetQlSyntaxNode {
    public VariableListSyntax(ISyntaxKind kind) {
        super(kind);
    }

    public VariableListSyntax(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public VariableListSyntax(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public VariableListSyntax(ISyntaxKind kind, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(kind, parent, missing, unexpected);
    }

    public VariableListSyntax(ISyntaxKind kind, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(kind, parent, start, missing, unexpected);
    }
}
