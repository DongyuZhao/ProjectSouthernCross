package project.southern_cross.code_analysis.core.syntax;

import project.southern_cross.code_analysis.core.SyntaxKind;
import project.southern_cross.code_analysis.core.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/26.
 */
public class RootSyntax extends SyntaxNode {
    public RootSyntax(boolean missing, boolean unexpected) {
        super(SyntaxKind.ROOT, missing, unexpected);
    }

    public RootSyntax(int start, boolean missing, boolean unexpected) {
        super(SyntaxKind.ROOT, start, missing, unexpected);
    }

    public RootSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(SyntaxKind.ROOT, start, end, missing, unexpected);
    }

    public RootSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(SyntaxKind.ROOT, start, end, fullEnd, missing, unexpected);
    }

    public RootSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(SyntaxKind.ROOT, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public RootSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(parent, SyntaxKind.ROOT, missing, unexpected);
    }

    public RootSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(parent, SyntaxKind.ROOT, start, missing, unexpected);
    }

    public RootSyntax(SyntaxNode parent, int start, int end, boolean missing, boolean unexpected) {
        super(parent, SyntaxKind.ROOT, start, end, missing, unexpected);
    }

    public RootSyntax(SyntaxNode parent, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, SyntaxKind.ROOT, start, end, fullEnd, missing, unexpected);
    }

    public RootSyntax(SyntaxNode parent, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, SyntaxKind.ROOT, start, end, fullStart, fullEnd, missing, unexpected);
    }
}
