package project.code_analysis.core.syntax;

import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.SyntaxNode;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CompilationUnitSyntax extends SyntaxNode {
    public CompilationUnitSyntax() {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX);
    }

    public CompilationUnitSyntax(boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, missing, unexpected);
    }

    public CompilationUnitSyntax(int start, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, missing, unexpected);
    }

    public CompilationUnitSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, end, missing, unexpected);
    }

    public CompilationUnitSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, end, fullEnd, missing, unexpected);
    }

    public CompilationUnitSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CompilationUnitSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, int start, int end, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, end, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, end, fullEnd, missing, unexpected, parent);
    }

    public CompilationUnitSyntax(SyntaxNode parent, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
