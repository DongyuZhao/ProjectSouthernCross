package project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;

/**
 * A syntax node class holds scope expression(e.g. expression surrounded by parentheses) in TweetQL
 */
public class ScopeExpression extends EvaluableExpression {
    public ScopeExpression() {
        super(TweetQlNodeKind.SCOPE_EXPRESSION);
    }

    public ScopeExpression(SyntaxError error) {
        super(TweetQlNodeKind.SCOPE_EXPRESSION, error);
    }

    public ScopeExpression(int start, SyntaxError error) {
        super(TweetQlNodeKind.SCOPE_EXPRESSION, start, error);
    }

    public ScopeExpression(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.SCOPE_EXPRESSION, parent, error);
    }

    public ScopeExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.SCOPE_EXPRESSION, parent, start, error);
    }
}
