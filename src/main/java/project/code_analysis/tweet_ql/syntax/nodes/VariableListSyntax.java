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

    public VariableListSyntax(ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, missing, unexpected, parent);
    }

    public VariableListSyntax(ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, missing, unexpected, parent);
    }

    @Override
    public String getRawString() {
        StringBuilder builder = new StringBuilder();
        this.getChildNodes().forEach(n -> {
            builder.append(n.getRawString());
            builder.append(", ");
        });
        if (builder.length() != 0) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.toString();
    }
}
