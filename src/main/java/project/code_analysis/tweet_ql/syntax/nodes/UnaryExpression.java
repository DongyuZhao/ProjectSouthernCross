package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class UnaryExpression extends EvaluableExpression {
    public UnaryExpression() {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION);
    }

    public UnaryExpression( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, missing, unexpected);
    }

    public UnaryExpression( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, missing, unexpected);
    }

    public UnaryExpression( int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, end, missing, unexpected);
    }

    public UnaryExpression( int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, end, fullEnd, missing, unexpected);
    }

    public UnaryExpression( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public UnaryExpression( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, missing, unexpected, parent);
    }

    public UnaryExpression( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, missing, unexpected, parent);
    }

    public UnaryExpression( int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, end, missing, unexpected, parent);
    }

    public UnaryExpression( int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, end, fullEnd, missing, unexpected, parent);
    }

    public UnaryExpression( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.UNARY_EXPRESSION, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }

    private EvaluableExpression subExpression;


    public void setSubExpression(EvaluableExpression subExpression) {
        this.subExpression = subExpression;
    }

    public EvaluableExpression getSubExpression() {
        return subExpression;
    }
}
