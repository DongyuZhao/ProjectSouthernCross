package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNode> childNodes = new ArrayList<>();
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();

    public SyntaxNode(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
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

    public void addChildNode(SyntaxNode child){
        this.childNodes.add(child);
        int spaceCount = this.fullSpan().end() - this.span().end();
        this.span().updateEnd(child.span().end());
        this.fullSpan().updateEnd(child.fullSpan().end());

    }

    public void addChildToken(SyntaxToken child) {
        this.childTokens.add(child);
        this.span().updateEnd(child.span().end());
        this.fullSpan().updateEnd(child.fullSpan().end());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.childNodes.size() == 0) {
            for (SyntaxToken token: this.childTokens) {
                stringBuilder.append(token.getRawString());
            }
        }
        else {
            for (SyntaxNode node: this.childNodes) {
                stringBuilder.append(node.toString());
            }
        }
        return stringBuilder.toString();
    }
}
