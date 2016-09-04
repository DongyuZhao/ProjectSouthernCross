package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class FieldAccessExpression extends UnaryExpression {
    public FieldAccessExpression() {
    }

    public FieldAccessExpression(SyntaxError error) {
        super(error);
    }

    public FieldAccessExpression(int start, SyntaxError error) {
        super(start, error);
    }

    public FieldAccessExpression(SyntaxNode parent, SyntaxError error) {
        super(parent, error);
    }

    public FieldAccessExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(parent, start, error);
    }

    public String getFieldName() {
        return this.getRawString();
    }
}
