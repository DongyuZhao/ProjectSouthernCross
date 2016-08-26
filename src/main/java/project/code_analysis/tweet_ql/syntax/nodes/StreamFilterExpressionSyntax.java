package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamFilterExpressionSyntax extends TweetQlSyntaxNode {
    public StreamFilterExpressionSyntax() {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected);
    }

    public StreamFilterExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, parent, missing, unexpected);
    }

    public StreamFilterExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, parent, start, missing, unexpected);
    }

    public String getExpectedValue() {
        if (this.hasChildToken() && this.getChildTokens().size() == 3) {
            return this.getChildTokens().get(2).getRawString();
        }
        return "";
    }

    public String getOperator() {
        if (this.hasChildToken() && this.getChildTokens().size() == 3) {
            return this.getChildTokens().get(1).getRawString();
        }
        return "";
    }

    public String getAttributeName() {
        if (this.hasChildToken()) {
            return this.getChildTokens().get(0).getRawString();
        }
        return "";
    }
}
