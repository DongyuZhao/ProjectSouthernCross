package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SymbolInfo;
import project.southern_cross.code_analysis.SyntaxNode;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/23 0023.
 */
public class UserDefinedTypeSyntax extends SyntaxNode {
    private SymbolInfo type;
    private ArrayList<String> attributes = new ArrayList<>();

<<<<<<< HEAD
    public UserDefinedTypeSyntax(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
=======
    public UserDefinedTypeSyntax(SyntaxNode parent, String name, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing, boolean isUnexpected, boolean withError) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing, isUnexpected, withError);
>>>>>>> 6d547d0cdb50f7ef8848169f4158f6b4ccc4ddfb
        this.type = new SymbolInfo(name);
    }

    public SymbolInfo getType() {
        return type;
    }

    public void setType(String type) {
        this.type = new SymbolInfo(type);
    }

    @Override
    public void addChildNode(SyntaxNode child) {
        if (child.kind() == TweetQlSyntaxKind.AttributeName) {
            this.attributes.add(child.toString());
        }
        super.addChildNode(child);
    }
}
