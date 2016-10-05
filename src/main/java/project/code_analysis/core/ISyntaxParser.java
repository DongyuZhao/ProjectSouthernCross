package project.code_analysis.core;

import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;

/**
 * The interface all syntax parser should implement
 *
 * <p>
 *     All syntax parser should provide a parse method to parse plain text into an abstract syntax tree
 * </p>
 */
public interface ISyntaxParser {
    /**
     * Parse the given plain text into an abstract syntax tree
     * @param source the given plain text
     * @return the abstract syntax tree
     */
    CompilationUnitSyntax parse(String source);
}
