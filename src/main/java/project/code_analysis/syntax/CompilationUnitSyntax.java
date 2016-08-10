package project.code_analysis.syntax;

import project.code_analysis.SyntaxKind;
import project.code_analysis.SyntaxNode;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CompilationUnitSyntax extends SyntaxNode {
    public CompilationUnitSyntax(SyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public CompilationUnitSyntax(SyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public CompilationUnitSyntax(SyntaxKind kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
    }

    public CompilationUnitSyntax(SyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
    }

    public CompilationUnitSyntax(SyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CompilationUnitSyntax(SyntaxNode parent, SyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, SyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, SyntaxKind kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, SyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, SyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
