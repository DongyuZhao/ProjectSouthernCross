package project.southern_cross.code_analysis.core.parser;

import project.southern_cross.code_analysis.core.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/22.
 */
public class SyntaxParseResult<T extends SyntaxNode> {
    private boolean modified;

    // the node contains the node the expected token should be added to
    // e.g. CREATE A FROM B; after CREATE, this node should be an CreateExpressionNode and,
    // after A, this node should also be an CreateExpressionNode.
    private T currentContextNode;

    private int postParserState;

    public SyntaxParseResult() {
        this.modified = false;
    }

    public SyntaxParseResult(T currentContextNode, int postParserState) {
        this.modified = true;
        this.currentContextNode = currentContextNode;
        this.postParserState = postParserState;
    }

    public boolean isModified() {
        return modified;
    }

    // the node contains the node the expected token should be added to
    // e.g. CREATE A FROM B; after CREATE, this node should be an CreateExpressionNode and,
    // after A, this node should also be an CreateExpressionNode.
    public T getCurrentContextNode() {
        return this.currentContextNode;
    }

    public int getPostParserState() {
        return this.postParserState;
    }
}
