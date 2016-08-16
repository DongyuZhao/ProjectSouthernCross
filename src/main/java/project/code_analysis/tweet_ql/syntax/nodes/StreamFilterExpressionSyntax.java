package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamFilterExpressionSyntax extends SyntaxNode {
    public StreamFilterExpressionSyntax() {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, end, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullEnd, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, end, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }

    public String getAttributeName() {
        if (this.hasChildToken()) {
            return this.childTokens.get(0).getRawString();
        }
        return "";
    }

    public String getExpectedValue() {
        if (this.hasChildToken() && this.childTokens.size() == 2) {
            return this.childTokens.get(2).getRawString();
        }
        return "";
    }

    public String getOperator() {
        if (this.hasChildToken() && this.childTokens.size() == 2) {
            return this.childTokens.get(1).getRawString();
        }
        return "";
    }

    @Override
    public String getRawString() {
        StringBuilder builder = new StringBuilder();
        this.childTokens.forEach(t -> builder.append(t.getRawString()));
        return builder.toString();
    }
}
