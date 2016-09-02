package project.code_analysis.core.syntax.nodes;

import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.SyntaxError;
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

    public CompilationUnitSyntax(String language, SyntaxError error) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, error);
    }

    public CompilationUnitSyntax(String language, int start, SyntaxError error) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, start, error);
    }

    public CompilationUnitSyntax(String language, SyntaxError error, SyntaxNode parent) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, parent, error);
    }

    public CompilationUnitSyntax(String language, int start, SyntaxError error, SyntaxNode parent) {
        super(language, AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, parent, start, error);
    }
}
