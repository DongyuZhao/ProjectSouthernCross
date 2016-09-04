package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

import java.util.Optional;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/4.
 */
public class SelectExpression extends TweetQlSyntaxNode {
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

    public AttributeList getAttributeList() {
        Optional<SyntaxNode> result = this.getChildNodes().stream().filter(n -> n.getKind() == TweetQlNodeKind.ATTRIBUTE_LIST).findFirst();
        if (result.isPresent()) {
            return (AttributeList) result.get();
        } else {
            return new AttributeList();
        }
    }

    public StreamSourceList getStreamSourceList() {
        Optional<SyntaxNode> result = this.getChildNodes().stream().filter(n -> n.getKind() == TweetQlNodeKind.STREAM_SOURCE_LIST).findFirst();
        if (result.isPresent()) {
            return (StreamSourceList) result.get();
        } else {
            return new StreamSourceList();
        }
    }
}
