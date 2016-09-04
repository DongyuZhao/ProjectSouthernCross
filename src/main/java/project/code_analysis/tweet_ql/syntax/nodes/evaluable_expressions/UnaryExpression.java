package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
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

    public EvaluableExpression getSubExpression() {
        if (this.hasChildNode() && EvaluableExpression.isEvaluable(this.getChildNodes().get(0))) {
            return ((EvaluableExpression) this.getChildNodes().get(0));
        } else {
            return null;
        }
    }
}
