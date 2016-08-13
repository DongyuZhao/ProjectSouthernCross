package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamFilterExpressionSyntax extends SyntaxNode {
    public StreamFilterExpressionSyntax() {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, end, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullEnd, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, end, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_FILTER_EXPRESSION_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
