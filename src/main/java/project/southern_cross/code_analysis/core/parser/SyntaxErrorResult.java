package project.southern_cross.code_analysis.core.parser;

import project.southern_cross.code_analysis.core.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/1.
 */
public class SyntaxErrorResult<T extends SyntaxNode> extends SyntaxParseResult<T> {

    private boolean dealt;

    private boolean needBackward;

    public SyntaxErrorResult() {
        this.needBackward = false;
        this.dealt = false;
    }

    public SyntaxErrorResult(T currentContextNode, int postParserState, boolean needBackward) {
        super(currentContextNode, postParserState);
        this.needBackward = needBackward;
        this.dealt = true;
    }

    public boolean isDealt() {
        return this.dealt;
    }

    public boolean isNeedBackward() {
        return this.needBackward;
    }
}
