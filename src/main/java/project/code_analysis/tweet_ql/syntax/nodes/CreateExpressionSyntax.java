package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CreateExpressionSyntax extends TweetQlSyntaxNode {

    //region constructor
    public CreateExpressionSyntax() {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE);
    }

    public CreateExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, parent, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, parent, start, missing, unexpected);
    }
    //endregion

    public StreamListSyntax getTargetList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 2) {
            if (this.getChildNodes().get(1).getKind() == TweetQlSyntaxNodeKind.STREAM_LIST_NODE) {
                return (StreamListSyntax) this.getChildNodes().get(1);
            }
        }
        return null;
    }

    public StreamListSyntax getSourceList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 1) {
            if (this.getChildNodes().get(0).getKind() == TweetQlSyntaxNodeKind.STREAM_LIST_NODE) {
                return (StreamListSyntax) this.getChildNodes().get(0);
            }
        }
        return null;
    }
}
