package project.southern_cross.code_analysis.tweet_ql.syntax;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.tweet_ql.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/14.
 */
public class SourceListExpressionSyntax extends SyntaxNode {
    public SourceListExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, missing, unexpected);
    }

    public SourceListExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, missing, unexpected);
    }

    public SourceListExpressionSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, end, missing, unexpected);
    }

    public SourceListExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, end, fullEnd, missing, unexpected);
    }

    public SourceListExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public SourceListExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, missing, unexpected);
    }

    public SourceListExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, missing, unexpected);
    }

    public SourceListExpressionSyntax(SyntaxNode parent, int start, int end, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, end, missing, unexpected);
    }

    public SourceListExpressionSyntax(SyntaxNode parent, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, end, fullEnd, missing, unexpected);
    }

    public SourceListExpressionSyntax(SyntaxNode parent, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.SOURCE_LIST_EXP_SYNTAX_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }
}
