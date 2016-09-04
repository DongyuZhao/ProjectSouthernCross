package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;
import project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions.*;

import java.util.List;
import java.util.Optional;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class EvaluableExpressionBuilder extends AbstractSyntaxNodeBuilder<EvaluableExpression> {

    @Override
    public EvaluableExpression build() {
        EvaluableExpression result = buildExpressionTree(null, this.tokenList);
        return result;
    }

    private EvaluableExpression buildExpressionTree(EvaluableExpression currentRoot, List<SyntaxToken> tokenList) {
        if (tokenList.size() == 0) {
            return (EvaluableExpression) currentRoot.getRootNode();
        } else {
            SyntaxToken token = tokenList.get(0);
            switch ((TweetQlTokenKind) token.getKind()) {
                case IDENTIFIER_TOKEN:
                    FieldAccessExpression fieldAccessExpression = new FieldAccessExpression();
                    fieldAccessExpression.addChildToken(token);
                    if (currentRoot != null) {
                        currentRoot.addChildNode(fieldAccessExpression);
                    }
                    return buildExpressionTree(fieldAccessExpression, tokenList.subList(1, tokenList.size()));
                case OPEN_PARENTHESES:
                    ScopeExpression scopeExpression = new ScopeExpression();
                    scopeExpression.addChildToken(token);
                    if (currentRoot != null) {
                        currentRoot.addChildNode(scopeExpression);
                    }
                    return buildExpressionTree(scopeExpression, tokenList.subList(1, tokenList.size()));
                case CLOSE_PARENTHESES:
                    if (currentRoot.getKind() != TweetQlNodeKind.SCOPE_EXPRESSION || currentRoot.getChildTokens().get(currentRoot.getChildTokenCount() - 1).getKind() == TweetQlTokenKind.CLOSE_PARENTHESES) {
                        Optional<SyntaxNode> newRootCandidate = currentRoot.getAncestorNode().stream().filter(n -> n.getKind() == TweetQlNodeKind.SCOPE_EXPRESSION).findFirst();
                        if (newRootCandidate.isPresent()) {
                            EvaluableExpression newRoot = (EvaluableExpression) newRootCandidate.get();
                            newRoot.addChildToken(token);
                            if (newRoot.getParentNode() != null && newRoot.getParentNode().getKind() == TweetQlNodeKind.UNARY_EXPRESSION) {
                                return buildExpressionTree((EvaluableExpression) newRoot.getParentNode(), tokenList.subList(1, tokenList.size()));
                            } else {
                                return buildExpressionTree(newRoot, tokenList.subList(1, tokenList.size()));
                            }
                        }
                    } else {
                        currentRoot.addChildToken(token);
                        if (currentRoot.getParentNode() != null && currentRoot.getParentNode().getKind() == TweetQlNodeKind.UNARY_EXPRESSION) {
                            return buildExpressionTree((EvaluableExpression) currentRoot.getParentNode(), tokenList.subList(1, tokenList.size()));
                        }
                        return buildExpressionTree(currentRoot, tokenList.subList(1, tokenList.size()));
                    }
                    break;
                case DIGIT_TOKEN:
                case LITERAL_STRING_TOKEN:
                    ValueExpression valueExpression = new ValueExpression();
                    valueExpression.addChildToken(token);
                    if (currentRoot != null) {
                        currentRoot.addChildNode(valueExpression);
                    }
                    return buildExpressionTree(valueExpression, tokenList.subList(1, tokenList.size()));
                default:
                    if (TweetQlSyntaxFacts.getInstance().isUnaryOperator(token.getKind())) {
                        UnaryExpression unaryExpression = new UnaryExpression();
                        unaryExpression.addChildToken(token);
                        if (currentRoot != null) {
                            currentRoot.addChildNode(unaryExpression);
                        }
                        return buildExpressionTree(unaryExpression, tokenList.subList(1, tokenList.size()));
                    } else if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getKind())) {
                        if (currentRoot.getParentNode() != null) {
                            BinaryExpression binaryExpression = new BinaryExpression();
                            EvaluableExpression newRoot = (EvaluableExpression) currentRoot.getParentNode();
                            binaryExpression.addChildNode(currentRoot);
                            binaryExpression.addChildToken(token);
                            newRoot.replaceNode(currentRoot, binaryExpression);
                            return buildExpressionTree(binaryExpression, tokenList.subList(1, tokenList.size()));
                        } else {
                            BinaryExpression binaryExpression = new BinaryExpression();
                            binaryExpression.addChildNode(currentRoot);
                            binaryExpression.addChildToken(token);
                            return buildExpressionTree(binaryExpression, tokenList.subList(1, tokenList.size()));
                        }
                    }
            }
        }
        return currentRoot;
    }
}
