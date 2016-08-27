package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class SelectExpressionSyntax extends TweetQlSyntaxNode {
    public SelectExpressionSyntax() {
        super(TweetQlNodeKind.SELECT_EXPRESSION);
    }

    public SelectExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, missing, unexpected);
    }

    public SelectExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, start, missing, unexpected);
    }

    public SelectExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, parent, missing, unexpected);
    }

    public SelectExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, parent, start, missing, unexpected);
    }

    public AttributeListSyntax getAttributeList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 1) {
            if (this.getChildNodes().get(0).getKind() == TweetQlNodeKind.ATTRIBUTE_LIST) {
                return (AttributeListSyntax) this.getChildNodes().get(0);
            }
        }
        return null;
    }

    public StreamListSyntax getSourceList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 2) {
            if (this.getChildNodes().get(1).getKind() == TweetQlNodeKind.STREAM_LIST) {
                return (StreamListSyntax) this.getChildNodes().get(1);
            }
        }
        return null;
    }
}
