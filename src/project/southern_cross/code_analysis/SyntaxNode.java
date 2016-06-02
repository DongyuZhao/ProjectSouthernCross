package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNode> childNodes = new ArrayList<>();
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();

    public SyntaxNode(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing, boolean isUnexpected, boolean withError) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing, isUnexpected, withError);
    }

    public ArrayList<SyntaxNode> childNodes() {
        return childNodes;
    }

    public ArrayList<SyntaxToken> childTokens() {
        return childTokens;
    }

    public ArrayList<SyntaxNode> descentNodes() {
        ArrayList<SyntaxNode> result = (ArrayList<SyntaxNode>) this.childNodes.clone();
        for (SyntaxNode syntaxNode : result) {
            if (syntaxNode.childNodes.size() != 0) {
                result.addAll(syntaxNode.descentNodes());
            }
        }
        return result;
    }

    public ArrayList<SyntaxNode> descentNodesAndSelf() {
        ArrayList<SyntaxNode> result = this.descentNodes();
        result.add(this);
        return result;
    }

    public void addChildNode(SyntaxNode child) {
        child.setParent(this);
        this.childNodes.add(child);
        int spaceCount = this.fullSpan().end() - this.span().end();
        this.span().updateEnd(child.span().end());
        this.fullSpan().updateEnd(child.fullSpan().end());
        this.setWithError(child.isWithError());

    }

    public void addChildToken(SyntaxToken child) {
        child.setParent(this);
        this.childTokens.add(child);
        this.span().updateEnd(child.span().end());
        this.fullSpan().updateEnd(child.fullSpan().end());
        this.setWithError(child.isWithError());
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < childNodes.size(); i++) {
            SyntaxNode node = childNodes.get(i);
            stringBuilder.append(node.toString());
            if (i != childNodes.size() - 1) {
                stringBuilder.append(" ");
            }
        }
        for (SyntaxToken token : this.childTokens) {
            stringBuilder.append(token.getRawString());
        }
        return stringBuilder.toString();
    }
}
