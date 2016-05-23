package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNode> _childNodes = new ArrayList<>();
    private ArrayList<SyntaxToken> _childTokens = new ArrayList<>();

    public SyntaxNode(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing) {
        super(parent, rawString, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind, isMissing);
    }

    public ArrayList<SyntaxNode> childNodes() {
        return _childNodes;
    }

    public ArrayList<SyntaxToken> childTokens() {
        return _childTokens;
    }

    public ArrayList<SyntaxNode> descentNodes() {
        ArrayList<SyntaxNode> result = (ArrayList<SyntaxNode>) this._childNodes.clone();
        for (SyntaxNode syntaxNode : result) {
            if (syntaxNode._childNodes.size() != 0) {
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
        this._childNodes.add(child);
        int spaceCount = this.fullSpan().end() - this.span().end();
        for (int i = 0; i < spaceCount; i++) {
            this._rawString += " ";
        }
        this._rawString += child._rawString;
        this.span().updateEnd(child.span().end());
        this.fullSpan().updateEnd(child.fullSpan().end());

    }

    public void addChildToken(SyntaxToken child) {
        this._childTokens.add(child);
        this.span().updateEnd(child.span().end());
        this.fullSpan().updateEnd(child.fullSpan().end());
    }
}
