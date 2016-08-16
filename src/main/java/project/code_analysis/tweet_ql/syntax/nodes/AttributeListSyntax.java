package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class AttributeListSyntax extends SyntaxNode {
    public AttributeListSyntax() {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE);
    }

    public AttributeListSyntax( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, missing, unexpected);
    }

    public AttributeListSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, missing, unexpected);
    }

    public AttributeListSyntax( int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, end, missing, unexpected);
    }

    public AttributeListSyntax( int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, end, fullEnd, missing, unexpected);
    }

    public AttributeListSyntax( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public AttributeListSyntax( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, missing, unexpected, parent);
    }

    public AttributeListSyntax( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, missing, unexpected, parent);
    }

    public AttributeListSyntax( int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, end, missing, unexpected, parent);
    }

    public AttributeListSyntax( int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, end, fullEnd, missing, unexpected, parent);
    }

    public AttributeListSyntax( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
