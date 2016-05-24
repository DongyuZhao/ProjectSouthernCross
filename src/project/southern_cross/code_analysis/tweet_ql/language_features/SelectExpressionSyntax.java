package project.southern_cross.code_analysis.tweet_ql.language_features;
import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Administrator on 23/05/2016.
 */
public class SelectExpressionSyntax extends SyntaxNode {
    public SelectExpressionSyntax(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
    }

}
