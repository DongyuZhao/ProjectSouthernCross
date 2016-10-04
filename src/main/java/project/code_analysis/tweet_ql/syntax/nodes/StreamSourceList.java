package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/4.
 */
public class StreamSourceList extends TweetQlSyntaxNode {
    public StreamSourceList() {
        super(TweetQlNodeKind.STREAM_SOURCE_LIST);
    }

    public StreamSourceList(SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE_LIST, error);
    }

    public StreamSourceList(int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE_LIST, start, error);
    }

    public StreamSourceList(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE_LIST, parent, error);
    }

    public StreamSourceList(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE_LIST, parent, start, error);
    }

    /**
     * Get the list of the stream sources
     * @return the list
     */
    public List<StreamSource> getStreamSources() {
        ArrayList<StreamSource> result = new ArrayList<>();
        this.getChildNodes().stream().filter(n -> n.getKind() == TweetQlNodeKind.STREAM_SOURCE).forEach(n -> result.add((StreamSource) n));
        return result;
    }
}
