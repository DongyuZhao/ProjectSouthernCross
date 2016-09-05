package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class FieldAccessExpression extends UnaryExpression {
    public FieldAccessExpression() {
        this.setKind(TweetQlNodeKind.FIELD_ACCESS_EXPRESSION);
    }

    public FieldAccessExpression(SyntaxError error) {
        super(error);
        this.setKind(TweetQlNodeKind.FIELD_ACCESS_EXPRESSION);
    }

    public FieldAccessExpression(int start, SyntaxError error) {
        super(start, error);
        this.setKind(TweetQlNodeKind.FIELD_ACCESS_EXPRESSION);
    }

    public FieldAccessExpression(SyntaxNode parent, SyntaxError error) {
        super(parent, error);
        this.setKind(TweetQlNodeKind.FIELD_ACCESS_EXPRESSION);
    }

    public FieldAccessExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(parent, start, error);
        this.setKind(TweetQlNodeKind.FIELD_ACCESS_EXPRESSION);
    }

    public String getFieldName() {
        if (this.hasChildToken()) {
            return this.getChildTokens().get(0).getRawString();
        } else {
            return "";
        }
    }
}
