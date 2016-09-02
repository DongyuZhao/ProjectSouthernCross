package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
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

    public SelectExpressionSyntax(SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, error);
    }

    public SelectExpressionSyntax(int start, SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, start, error);
    }

    public SelectExpressionSyntax(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, parent, error);
    }

    public SelectExpressionSyntax(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, parent, start, error);
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
