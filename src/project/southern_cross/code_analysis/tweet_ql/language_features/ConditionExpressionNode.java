package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Created by Dy.Zhao on 2016/5/23 0023.
 */
public class ConditionExpressionNode extends SyntaxNode {
    public ConditionExpressionNode(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, rawString, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
    }
}
