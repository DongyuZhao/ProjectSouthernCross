package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * CompileUnitd by Dy.Zhao on 2016/8/13.
 */
public class CompileUnitNode extends SyntaxNode {
    public CompileUnitNode() {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE);
    }

    public CompileUnitNode(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, missing, unexpected);
    }

    public CompileUnitNode(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, missing, unexpected);
    }

    public CompileUnitNode(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, end, missing, unexpected);
    }

    public CompileUnitNode(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, end, fullEnd, missing, unexpected);
    }

    public CompileUnitNode(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CompileUnitNode(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, missing, unexpected, parent);
    }

    public CompileUnitNode(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, missing, unexpected, parent);
    }

    public CompileUnitNode(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, end, missing, unexpected, parent);
    }

    public CompileUnitNode(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public CompileUnitNode(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.COMPILE_UNIT_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
