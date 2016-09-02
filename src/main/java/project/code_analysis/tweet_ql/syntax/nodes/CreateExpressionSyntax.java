package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
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

    public CreateExpressionSyntax(SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, error);
    }

    public CreateExpressionSyntax(int start, SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, start, error);
    }

    public CreateExpressionSyntax(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, parent, error);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, parent, start, error);
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
