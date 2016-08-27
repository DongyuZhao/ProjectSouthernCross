package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CreateExpressionSyntax extends TweetQlSyntaxNode {

    //region constructor
    public CreateExpressionSyntax() {
        super(TweetQlNodeKind.CREATE_EXPRESSION);
    }

    public CreateExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, start, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, parent, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, parent, start, missing, unexpected);
    }
    //endregion

    public StreamListSyntax getTargetList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 2) {
            if (this.getChildNodes().get(1).getKind() == TweetQlNodeKind.STREAM_LIST) {
                return (StreamListSyntax) this.getChildNodes().get(1);
            }
        }
        return null;
    }

    public StreamListSyntax getSourceList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 1) {
            if (this.getChildNodes().get(0).getKind() == TweetQlNodeKind.STREAM_LIST) {
                return (StreamListSyntax) this.getChildNodes().get(0);
            }
        }
        return null;
    }
}
