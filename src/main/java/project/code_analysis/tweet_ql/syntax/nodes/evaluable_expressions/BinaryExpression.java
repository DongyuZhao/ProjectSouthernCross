package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

import java.util.Optional;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class BinaryExpression extends EvaluableExpression {
    public BinaryExpression() {
        super(TweetQlNodeKind.BINARY_EXPRESSION);
    }

    public BinaryExpression(SyntaxError error) {
        super(TweetQlNodeKind.BINARY_EXPRESSION, error);
    }

    public BinaryExpression(int start, SyntaxError error) {
        super(TweetQlNodeKind.BINARY_EXPRESSION, start, error);
    }

    public BinaryExpression(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.BINARY_EXPRESSION, parent, error);
    }

    public BinaryExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.BINARY_EXPRESSION, parent, start, error);
    }

    public EvaluableExpression getFirstSubExpression() {
        Optional<SyntaxNode> result = this.getChildNodes().stream().filter(EvaluableExpression::isEvaluable).findFirst();
        if (result.isPresent()) {
            return (EvaluableExpression) (result.get());
        } else {
            return null;
        }
    }

    public BinaryOperatorToken getOperator() {
        Optional<SyntaxToken> result = this.getChildTokens().stream().filter(BinaryOperatorToken::isBinaryOperator).findFirst();
        if (result.isPresent()) {
            return (BinaryOperatorToken) (result.get());
        } else {
            return new BinaryOperatorToken("", TweetQlTokenKind.UNDETERMINED_TOKEN, SyntaxError.getMissingError("BinaryOperatorToken"));
        }
    }

    public EvaluableExpression getSecondSubExpression() {
        EvaluableExpression[] result = (EvaluableExpression[]) this.getChildNodes().stream().filter(EvaluableExpression::isEvaluable).toArray();
        if (result.length == 2) {
            return result[1];
        } else {
            return null;
        }
    }
}
