package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class ValueExpression extends UnaryExpression {
    public ValueExpression() {
    }

    public ValueExpression(SyntaxError error) {
        super(error);
    }

    public ValueExpression(int start, SyntaxError error) {
        super(start, error);
    }

    public ValueExpression(SyntaxNode parent, SyntaxError error) {
        super(parent, error);
    }

    public ValueExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(parent, start, error);
    }

    public String getValue() {
        return this.getRawString();
    }
}
