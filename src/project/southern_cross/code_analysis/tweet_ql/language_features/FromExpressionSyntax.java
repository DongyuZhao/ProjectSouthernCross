package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SyntaxNode;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/23 0023.
 */
public class FromExpressionSyntax extends SyntaxNode {
    public FromExpressionSyntax(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing, boolean isUnexpected, boolean withError) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing, isUnexpected, withError);
    }



    private UserDefinedTypeSyntax source;

    public UserDefinedTypeSyntax getSource() {
        return source;
    }

    public void setSource(UserDefinedTypeSyntax source) {
        this.source = source;
    }
}
