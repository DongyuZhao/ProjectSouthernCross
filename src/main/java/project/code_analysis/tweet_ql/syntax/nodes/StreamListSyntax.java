package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamListSyntax extends VariableListSyntax {
    public StreamListSyntax() {
        super(TweetQlNodeKind.STREAM_LIST);
    }

    public StreamListSyntax(SyntaxError error) {
        super(TweetQlNodeKind.STREAM_LIST, error);
    }

    public StreamListSyntax(int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_LIST, start, error);
    }

    public StreamListSyntax(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_LIST, parent, error);
    }

    public StreamListSyntax(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_LIST, parent, start, error);
    }


    public List<VariableSyntax> getStreams() {
        ArrayList<VariableSyntax> result = new ArrayList<>();
        if (this.hasChildNode()) {
            this.getChildNodes().forEach(u -> {
                if (u.getKind() == TweetQlNodeKind.USER_DEFINED_TYPE) {
                    result.add((VariableSyntax) u);
                }
            });
        }
        return result;
    }
}

