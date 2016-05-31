package project.southern_cross.code_analysis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxTree {
    private SyntaxNode _root;
    private String _filePath = "";

    public SyntaxNode root() {
        return this._root;
    }

    public SyntaxTree() {

    }

    public SyntaxTree(SyntaxNode root) {
        this._root = root;
    }

    public SyntaxTree(String filePath) {
        this._filePath = filePath;
    }

    public String filePath() {
        return this._filePath;
    }

    public abstract void ParseSource(String source);
}
