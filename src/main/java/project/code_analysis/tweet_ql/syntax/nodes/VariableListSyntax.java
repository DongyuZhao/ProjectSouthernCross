package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
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

    public VariableListSyntax(ISyntaxKind kind, SyntaxError error) {
        super(kind, error);
    }

    public VariableListSyntax(ISyntaxKind kind, int start, SyntaxError error) {
        super(kind, start, error);
    }

    public VariableListSyntax(ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(kind, parent, error);
    }

    public VariableListSyntax(ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(kind, parent, start, error);
    }
}
