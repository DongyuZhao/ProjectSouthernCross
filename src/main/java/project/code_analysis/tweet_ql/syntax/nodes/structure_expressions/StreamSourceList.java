package project.code_analysis.tweet_ql.syntax.nodes.structure_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.StructureExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * A syntax node class holds stream list
 */
public class StreamSourceList extends StructureExpression {
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
