package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * A syntax node class holds value in TweetQL
 */
public class ValueExpression extends UnaryExpression {
    public ValueExpression() {
        this.setKind(TweetQlNodeKind.VALUE_EXPRESSION);
    }

    public ValueExpression(SyntaxError error) {
        super(error);
        this.setKind(TweetQlNodeKind.VALUE_EXPRESSION);
    }

    public ValueExpression(int start, SyntaxError error) {
        super(start, error);
        this.setKind(TweetQlNodeKind.VALUE_EXPRESSION);
    }

    public ValueExpression(SyntaxNode parent, SyntaxError error) {
        super(parent, error);
        this.setKind(TweetQlNodeKind.VALUE_EXPRESSION);
    }

    public ValueExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(parent, start, error);
        this.setKind(TweetQlNodeKind.VALUE_EXPRESSION);
    }

    /**
     * Get the value held by this node
     * @return the value held by this node
     */
    public String getValue() {
        if (this.hasChildToken()) {
            return this.getChildTokens().get(0).getRawString();
        } else {
            return "";
        }
    }
}
