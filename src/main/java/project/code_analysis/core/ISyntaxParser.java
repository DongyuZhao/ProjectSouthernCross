package project.code_analysis.core;

import project.code_analysis.core.syntax.CompilationUnitSyntax;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/16.
 */
public interface ISyntaxParser {
    CompilationUnitSyntax parse(String source);
}
