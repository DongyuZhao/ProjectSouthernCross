package project.code_analysis.core;

import project.code_analysis.core.syntax.CompilationUnitSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public abstract class SyntaxTree {
    private CompilationUnitSyntax root;
    private ISyntaxParser parser;

    protected SyntaxTree(ISyntaxParser parser) {
        this.parser = parser;
    }

    public SyntaxTree parseText(String sourceCode) {
        this.root = this.parser.parse(sourceCode);
        return this;
    }

    public CompilationUnitSyntax getRoot() {
        if (this.root == null) {
            return new CompilationUnitSyntax("");
        } else {
            return this.root;
        }
    }
}
