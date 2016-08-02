package project.southern_cross.code_analysis.tweet_ql.syntax;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.tweet_ql.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/3.
 */
public class FromExpressionSyntax extends SyntaxNode {
    public FromExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.FROM_SYNTAX_NODE, missing, unexpected);
    }

    public FromExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, missing, unexpected);
    }

    public FromExpressionSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, end, missing, unexpected);
    }

    public FromExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, end, fullEnd, missing, unexpected);
    }

    public FromExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public FromExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.FROM_SYNTAX_NODE, missing, unexpected);
    }

    public FromExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, missing, unexpected);
    }

    public FromExpressionSyntax(SyntaxNode parent, int start, int end, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, end, missing, unexpected);
    }

    public FromExpressionSyntax(SyntaxNode parent, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, end, fullEnd, missing, unexpected);
    }

    public FromExpressionSyntax(SyntaxNode parent, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.FROM_SYNTAX_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }
}
