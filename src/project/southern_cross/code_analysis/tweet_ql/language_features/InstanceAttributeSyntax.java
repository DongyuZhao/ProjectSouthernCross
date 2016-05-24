package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SymbolInfo;
import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class InstanceAttributeSyntax extends SyntaxNode {
    private SymbolInfo type;
    public InstanceAttributeSyntax(SyntaxNode parent, String name, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
        this.type = new SymbolInfo(name);
    }

    public SymbolInfo getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.type.getName();
    }
}
