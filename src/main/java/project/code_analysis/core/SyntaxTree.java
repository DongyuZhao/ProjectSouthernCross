package project.code_analysis.core;

import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;

/**
 * The basic class of all of the syntax trees
 */
public abstract class SyntaxTree {
    private CompilationUnitSyntax root;
    private ISyntaxParser parser;

    /**
     * Get a new instance of a syntax tree initialed with the given parser
     * @param parser the given parser
     */
    protected SyntaxTree(ISyntaxParser parser) {
        this.parser = parser;
    }

    /**
     * Parse the given plain text into an abstract syntax tree
     * @param sourceCode the given plain text
     * @return the abstract syntax tree
     */
    protected SyntaxTree parse(String sourceCode) {
        this.root = this.parser.parse(sourceCode);
        return this;
    }

    /**
     * Get the root of the current tree
     * @return the root of the current tree
     */
    public CompilationUnitSyntax getRoot() {
        if (this.root == null) {
            return new CompilationUnitSyntax("");
        } else {
            return this.root;
        }
    }
}
