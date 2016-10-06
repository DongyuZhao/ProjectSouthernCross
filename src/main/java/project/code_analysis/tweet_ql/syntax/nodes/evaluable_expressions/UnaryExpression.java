package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;
import project.code_analysis.tweet_ql.syntax.tokens.UnaryOperatorToken;

import java.util.Optional;

/**
 * A syntax node class holds unary expression in TweetQL
 */
public class UnaryExpression extends EvaluableExpression {
    public UnaryExpression() {
        super(TweetQlNodeKind.UNARY_EXPRESSION);
    }

    public UnaryExpression(SyntaxError error) {
        super(TweetQlNodeKind.UNARY_EXPRESSION, error);
    }

    public UnaryExpression(int start, SyntaxError error) {
        super(TweetQlNodeKind.UNARY_EXPRESSION, start, error);
    }

    public UnaryExpression(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.UNARY_EXPRESSION, parent, error);
    }

    public UnaryExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.UNARY_EXPRESSION, parent, start, error);
    }

    /**
     * Get the expression augmented by this node.
     * @return the expression
     */
    public EvaluableExpression getSubExpression() {
        if (this.hasChildNode() && EvaluableExpression.isEvaluable(this.getChildNodes().get(0))) {
            return ((EvaluableExpression) this.getChildNodes().get(0));
        } else {
            return null;
        }
    }

    /**
     * Get the operator of this expression
     * @return the operator of this expression
     */
    public UnaryOperatorToken getOperator() {
        Optional<SyntaxToken> result = this.getChildTokens().stream().filter(UnaryOperatorToken::isUnaryOperator).findFirst();
        if (result.isPresent()) {
            return (UnaryOperatorToken) (result.get());
        } else {
            return new UnaryOperatorToken("", TweetQlTokenKind.UNDETERMINED_TOKEN);
        }
    }
}
