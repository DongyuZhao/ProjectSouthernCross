package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamListSyntax extends SyntaxNode {
    public StreamListSyntax() {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE);
    }

    public StreamListSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, missing, unexpected);
    }

    public StreamListSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, missing, unexpected);
    }

    public StreamListSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, end, missing, unexpected);
    }

    public StreamListSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, end, fullEnd, missing, unexpected);
    }

    public StreamListSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public StreamListSyntax(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, end, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.STREAM_LIST_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
