package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class BinaryExpression extends EvaluableExpression {
    public BinaryExpression() {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION);
    }

    public BinaryExpression( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, missing, unexpected);
    }

    public BinaryExpression( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, missing, unexpected);
    }

    public BinaryExpression( int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, end, missing, unexpected);
    }

    public BinaryExpression( int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, end, fullEnd, missing, unexpected);
    }

    public BinaryExpression( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public BinaryExpression( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, missing, unexpected, parent);
    }

    public BinaryExpression( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, missing, unexpected, parent);
    }

    public BinaryExpression( int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, end, missing, unexpected, parent);
    }

    public BinaryExpression( int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, end, fullEnd, missing, unexpected, parent);
    }

    public BinaryExpression( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.BINARY_EXPRESSION, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }

    private EvaluableExpression leftSubExpression;

    private EvaluableExpression rightSubExpression;

    public EvaluableExpression getLeftSubExpression() {
        return leftSubExpression;
    }

    public void setLeftSubExpression(EvaluableExpression leftSubExpression) {
        this.leftSubExpression = leftSubExpression;
    }

    public EvaluableExpression getRightSubExpression() {
        return rightSubExpression;
    }

    public void setRightSubExpression(EvaluableExpression rightSubExpression) {
        this.rightSubExpression = rightSubExpression;
    }
}
