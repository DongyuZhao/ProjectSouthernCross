package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxTree {
    private SyntaxNode root;
    private String filePath = "";

    public SyntaxNode root() {
        return this.root;
    }

    public SyntaxTree() {

    }

    public SyntaxTree(SyntaxNode root) {
        this.root = root;
    }

    public SyntaxTree(String filePath) {
        this.filePath = filePath;
    }

    public String filePath() {
        return this.filePath;
    }
}
