package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamListSyntax extends UserDefinedTypeListSyntax {
    public StreamListSyntax() {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE);
    }

    public StreamListSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, missing, unexpected);
    }

    public StreamListSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, missing, unexpected);
    }

    public StreamListSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, end, missing, unexpected);
    }

    public StreamListSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, end, fullEnd, missing, unexpected);
    }

    public StreamListSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public StreamListSyntax(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, end, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public StreamListSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }


    public List<UserDefinedTypeSyntax> getSource() {
        ArrayList<UserDefinedTypeSyntax> result = new ArrayList<>();
        if (this.hasChildNode()) {
            this.getChildNodes().forEach(u -> {
                if (u.getKind() == TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE) {
                    result.add((UserDefinedTypeSyntax) u);
                }
            });
        }
        return result;
    }

    @Override
    public String getRawString() {
        return super.getRawString();
    }
}

