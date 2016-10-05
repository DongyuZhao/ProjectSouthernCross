package project.code_analysis.tweet_ql.syntax.nodes.structure_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.StructureExpression;

import java.util.Optional;

/**
 * A syntax node class holds select expression
 */
public class SelectExpression extends StructureExpression {
    public SelectExpression() {
        super(TweetQlNodeKind.SELECT_EXPRESSION);
    }

    public SelectExpression(SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, error);
    }

    public SelectExpression(int start, SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, start, error);
    }

    public SelectExpression(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, parent, error);
    }

    public SelectExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.SELECT_EXPRESSION, parent, start, error);
    }

    /**
     * Get the specified attributes
     * @return the attribute list contains the specified attributes
     */
    public AttributeList getAttributeList() {
        Optional<SyntaxNode> result = this.getChildNodes().stream().filter(n -> n.getKind() == TweetQlNodeKind.ATTRIBUTE_LIST).findFirst();
        if (result.isPresent()) {
            return (AttributeList) result.get();
        } else {
            return new AttributeList();
        }
    }

    /**
     * Get the specified stream sources
     * @return the stream source list contains the specified source streams
     */
    public StreamSourceList getStreamSourceList() {
        Optional<SyntaxNode> result = this.getChildNodes().stream().filter(n -> n.getKind() == TweetQlNodeKind.STREAM_SOURCE_LIST).findFirst();
        if (result.isPresent()) {
            return (StreamSourceList) result.get();
        } else {
            return new StreamSourceList();
        }
    }
}
