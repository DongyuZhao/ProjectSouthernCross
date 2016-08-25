package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class AttributeListSyntax extends VariableListSyntax {
    public AttributeListSyntax() {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE);
    }

    public AttributeListSyntax( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, missing, unexpected);
    }

    public AttributeListSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, missing, unexpected);
    }

    public AttributeListSyntax( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, missing, unexpected, parent);
    }

    public AttributeListSyntax( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.ATTRIBUTE_LIST_NODE, start, missing, unexpected, parent);
    }

    public List<VariableSyntax> getAttributes() {
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
