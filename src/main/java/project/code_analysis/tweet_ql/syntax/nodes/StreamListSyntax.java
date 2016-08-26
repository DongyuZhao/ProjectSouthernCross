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
public class StreamListSyntax extends VariableListSyntax {
    public StreamListSyntax() {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE);
    }

    public StreamListSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, missing, unexpected);
    }

    public StreamListSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, start, missing, unexpected);
    }

    public StreamListSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, parent, missing, unexpected);
    }

    public StreamListSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_LIST_NODE, parent, start, missing, unexpected);
    }


    public List<VariableSyntax> getStreams() {
        ArrayList<VariableSyntax> result = new ArrayList<>();
        if (this.hasChildNode()) {
            this.getChildNodes().forEach(u -> {
                if (u.getKind() == TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE) {
                    result.add((VariableSyntax) u);
                }
            });
        }
        return result;
    }
}

