package project.southern_cross.code_analysis.tweet_ql.language_features;
import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Created by Administrator on 23/05/2016.
 */
public class SelectExpressionSyntax extends SyntaxNode {
    public SelectExpressionSyntax(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
    }

}
