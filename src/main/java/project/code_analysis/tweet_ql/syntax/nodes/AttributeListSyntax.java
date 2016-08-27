package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class AttributeListSyntax extends VariableListSyntax {
    public AttributeListSyntax() {
        super(TweetQlNodeKind.ATTRIBUTE_LIST);
    }

    public AttributeListSyntax( boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, missing, unexpected);
    }

    public AttributeListSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, start, missing, unexpected);
    }

    public AttributeListSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, parent, missing, unexpected);
    }

    public AttributeListSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.ATTRIBUTE_LIST, parent, start, missing, unexpected);
    }

    public List<VariableSyntax> getAttributes() {
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
