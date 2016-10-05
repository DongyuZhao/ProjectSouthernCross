package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;


/**
 * A common parent of all of the structure expressions in TweetQL
 */
public class StructureExpression extends TweetQlSyntaxNode {
    public StructureExpression(ISyntaxKind kind) {
        super(kind);
    }

    public StructureExpression(ISyntaxKind kind, SyntaxError error) {
        super(kind, error);
    }

    public StructureExpression(ISyntaxKind kind, int start, SyntaxError error) {
        super(kind, start, error);
    }

    public StructureExpression(ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(kind, parent, error);
    }

    public StructureExpression(ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(kind, parent, start, error);
    }
}
