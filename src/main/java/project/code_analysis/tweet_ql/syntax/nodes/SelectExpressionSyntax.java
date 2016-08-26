package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class SelectExpressionSyntax extends TweetQlSyntaxNode {
    public SelectExpressionSyntax() {
        super(TweetQlSyntaxNodeKind.SELECT_EXPRESSION_NODE);
    }

    public SelectExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.SELECT_EXPRESSION_NODE, missing, unexpected);
    }

    public SelectExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.SELECT_EXPRESSION_NODE, start, missing, unexpected);
    }

    public SelectExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.SELECT_EXPRESSION_NODE, parent, missing, unexpected);
    }

    public SelectExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.SELECT_EXPRESSION_NODE, parent, start, missing, unexpected);
    }

    @Override
    public String getRawString() {
        return "SELECT " + this.getAttributeList().getRawString() + " FROM " + this.getSourceList().getRawString() + ";";
    }

    public AttributeListSyntax getAttributeList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 1) {
            if (this.getChildNodes().get(0).getKind() == TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE) {
                return (AttributeListSyntax) this.getChildNodes().get(0);
            }
        }
        return null;
    }

    public StreamListSyntax getSourceList() {
        if (this.hasChildNode() && this.getChildNodes().size() >= 2) {
            if (this.getChildNodes().get(1).getKind() == TweetQlSyntaxNodeKind.STREAM_LIST_NODE) {
                return (StreamListSyntax) this.getChildNodes().get(1);
            }
        }
        return null;
    }
}
