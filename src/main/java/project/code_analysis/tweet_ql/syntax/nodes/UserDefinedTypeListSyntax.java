package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxNode;

/**
 * Created by Dy.Zhao on 2016/8/23.
 */
public class UserDefinedTypeListSyntax extends SyntaxNode {
    public UserDefinedTypeListSyntax(ISyntaxKind kind) {
        super(kind);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, missing, unexpected, parent);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, missing, unexpected, parent);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, missing, unexpected, parent);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, fullEnd, missing, unexpected, parent);
    }

    public UserDefinedTypeListSyntax(ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected, parent);
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
