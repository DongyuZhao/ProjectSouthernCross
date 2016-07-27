package project.southern_cross.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
public class ParsedSyntaxTree {
    private SyntaxNode root;

    public ParsedSyntaxTree(SyntaxNode root) {
        this.root = root;
    }

    public SyntaxNode getRoot() {
        return root;
    }
}
