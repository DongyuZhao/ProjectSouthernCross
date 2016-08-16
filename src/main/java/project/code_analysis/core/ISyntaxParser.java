package project.code_analysis.core;

import project.code_analysis.core.syntax.CompilationUnitSyntax;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public interface ISyntaxParser {
    CompilationUnitSyntax parse(String source);
}
