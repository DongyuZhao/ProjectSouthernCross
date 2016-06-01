package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SymbolInfo;
import project.southern_cross.code_analysis.SyntaxNode;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class SystemObjectSyntax extends SyntaxNode {
    private SymbolInfo type;
    public SystemObjectSyntax(SyntaxNode parent, String type, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing, boolean isUnexpected, boolean withError) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing, isUnexpected, withError);
        this.type = new SymbolInfo(type);
    }


    public SystemObjectSyntax(SyntaxNode parent, String type, String convertedType, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing, boolean isUnexpected, boolean withError) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing, isUnexpected, withError);
        this.type = new SymbolInfo(type, convertedType);
    }

    public SymbolInfo getType() {
        return type;
    }

    public void setType(String type) {
        this.type = new SymbolInfo(type);
    }

    public void setType(String type, String convertedType) {
        this.type = new SymbolInfo(type, convertedType);
    }

    @Override
    public String toString() {
        if (this.type.getConvertedType().equals("")) {
            // collection name
            return "[" + this.type.getType() + "]";
        }
        else {
            // collection id
            return "(" + this.type.getConvertedType() + ")";
        }
    }
}
