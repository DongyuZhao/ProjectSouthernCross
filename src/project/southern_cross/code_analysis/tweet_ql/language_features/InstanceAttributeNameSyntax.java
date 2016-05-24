package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class InstanceAttributeNameSyntax extends SyntaxNode {
    public InstanceAttributeNameSyntax(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, rawString, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
    }
}
