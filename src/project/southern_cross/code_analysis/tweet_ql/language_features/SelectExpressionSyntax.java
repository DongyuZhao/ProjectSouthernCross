package project.southern_cross.code_analysis.tweet_ql.language_features;
import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Created by Administrator on 23/05/2016.
 */
public class SelectExpressionSyntax extends SyntaxNode {
    public SelectExpressionSyntax(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, rawString, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
    }

}
