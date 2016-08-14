package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CreateExpressionSyntax extends SyntaxNode {

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

    public CreateExpressionSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, end, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, end, fullEnd, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CreateExpressionSyntax(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, missing, unexpected, parent);
    }

    public CreateExpressionSyntax(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, missing, unexpected, parent);
    }

    public CreateExpressionSyntax(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, end, missing, unexpected, parent);
    }

    public CreateExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public CreateExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.CREATE_EXPRESSION_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
    //endregion

    public List<UserDefinedTypeSyntax> getTargetList() {
        if (this.hasChildNode() && this.getChildNodes().get(0).getKind() == TweetQlSyntaxNodeKind.STREAM_LIST_NODE) {
            return this.extractStreamList((StreamListSyntax) this.getChildNodes().get(0));
        }
        return new ArrayList<>();
    }

    public List<UserDefinedTypeSyntax> getSourceList() {
        if (this.getChildNodes().size() > 1 && this.getChildNodes().get(1).getKind() == TweetQlSyntaxNodeKind.STREAM_LIST_NODE) {
            return this.extractStreamList((StreamListSyntax) this.getChildNodes().get(1));
        }
        return new ArrayList<>();
    }

    private List<UserDefinedTypeSyntax> extractStreamList(StreamListSyntax streamList) {
        ArrayList<UserDefinedTypeSyntax> result = new ArrayList<>();
        if (streamList != null) {
            streamList.getChildNodes().forEach(n -> {
                if (n.getKind() == TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE) {
                    result.add((UserDefinedTypeSyntax)n);
                }
            });
        }
        return result;
    }
}
