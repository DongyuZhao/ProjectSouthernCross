package project.code_analysis.tweet_ql.syntax.nodes.structure_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.StructureExpression;
import project.code_analysis.tweet_ql.syntax.tokens.data.IdentifierToken;

import java.util.ArrayList;
import java.util.List;

/**
 * A syntax node class holds attribute list in TweetQL
 */
public class AttributeList extends StructureExpression {
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

    /**
     * Get the specified attribute names
     * @return the list of tokens contains attribute name
     */
    public List<IdentifierToken> getAttributes() {
        ArrayList<IdentifierToken> result = new ArrayList<>();
        this.getChildTokens().stream().filter(IdentifierToken::isIdentifier).forEach(t -> result.add((IdentifierToken) t));
        return result;
    }
}
