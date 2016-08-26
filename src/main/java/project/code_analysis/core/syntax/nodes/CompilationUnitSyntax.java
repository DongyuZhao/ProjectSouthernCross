package project.code_analysis.core.syntax.nodes;

import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.SyntaxNode;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CompilationUnitSyntax extends SyntaxNode {

    public CompilationUnitSyntax(String language) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX);
    }

    public CompilationUnitSyntax(String language, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, missing, unexpected);
    }

    public CompilationUnitSyntax(String language, int start, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, missing, unexpected);
    }

    public CompilationUnitSyntax(String language, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, parent, missing, unexpected);
    }

    public CompilationUnitSyntax(String language, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, parent, start, missing, unexpected);
    }
}
