package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/4.
 */
public class AttributeList extends TweetQlSyntaxNode {
    public AttributeList() {
        super(TweetQlNodeKind.ATTRIBUTE_LIST);
    }

    public AttributeList(SyntaxError error) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, error);
    }

    public AttributeList(int start, SyntaxError error) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, start, error);
    }

    public AttributeList(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, parent, error);
    }

    public AttributeList(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, parent, start, error);
    }
}
