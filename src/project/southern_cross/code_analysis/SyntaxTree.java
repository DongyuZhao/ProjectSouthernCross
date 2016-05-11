package project.southern_cross.code_analysis;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxTree {
    private SyntaxNode _root;
    private String _filePath = "";

    public SyntaxNode root() {
        return this._root;
    }

    public SyntaxTree(String source) {

    }

    public SyntaxTree(String source, String filePath) {
        this._filePath = filePath;
    }

    public String filePath() {
        return this._filePath;
    }
}
