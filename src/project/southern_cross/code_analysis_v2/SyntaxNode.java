package project.southern_cross.code_analysis_v2;

import javax.management.relation.RelationSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNode> childNodes = new ArrayList<>();
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();


    public SyntaxNode(int kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, boolean missing, boolean unexpected) {
        super(parent, kind, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, boolean missing, boolean unexpected) {
        super(parent, kind, start, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, int end, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullEnd, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public void addChildNode(SyntaxNode child) {
        int index = this.findSyntaxNodeInsertIndex(child.getFullStart(), child.getFullEnd());
        if (index != -1) {
            this.addChildNode(child, index);
            return;
        }
        throw new IllegalArgumentException("New SyntaxNode's position is not suitable for the existing nodes.");
    }

    public List<SyntaxNode> getChildNodes() {
        return new ArrayList<>(this.childNodes);
    }

    public List<SyntaxNode> getDescendNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>(this.childNodes);
        for (int i = 0; i < result.size(); i++) {
            result.addAll(result.get(i).getChildNodes());
        }
        return result;
    }

    public List<SyntaxNode> getDescendNodesAndSelf() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        result.add(this);
        result.addAll(this.getDescendNodes());
        return result;
    }

    public List<SyntaxNode> getAncestorNodeAndSelf() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        result.add(this);
        result.addAll(this.getAncestorNode());
        return result;
    }

    public void addChildNode(SyntaxNode child, int index) {
        child.setParentNode(this);
        this.childNodes.add(index, child);
        this.setStart(child.getStart());
        this.setFullStart(child.getFullStart());
        this.setEnd(child.getEnd());
        this.setFullEnd(child.getFullEnd());
    }

    public void addChildToken(SyntaxToken child) {
        int index = this.findSyntaxTokenInsertIndex(child.getFullStart(), child.getFullEnd());
        if (index != -1) {
            this.addChildToken(child, index);
            return;
        }
        throw new IllegalArgumentException("New SyntaxToken's position is not suitable for the existing nodes.");
    }

    public List<SyntaxToken> getChildTokens() {
        return new ArrayList<>(childTokens);
    }

    public List<SyntaxToken> getDescendTokens() {
        ArrayList<SyntaxToken> result = new ArrayList<>(this.childTokens);
        this.getDescendNodes().stream().forEach(node -> result.addAll(node.getChildTokens()));
        return result;
    }

    public void addChildToken(SyntaxToken child, int index) {
        child.setParentNode(this);
        this.childTokens.add(index, child);
        this.setStart(child.getStart());
        this.setFullStart(child.getFullStart());
        this.setEnd(child.getEnd());
        this.setFullEnd(child.getFullEnd());
    }

    protected int findSyntaxNodeInsertIndex(int start, int end) {
        if (this.childNodes.size() == 0) {
            return 0;
        }
        if (end < this.childNodes.get(0).getFullStart()) {
            return 0;
        }
        if (start >= this.childNodes.get(this.childNodes.size() - 1).getFullEnd()) {
            return this.childNodes.size();
        }
        for (int i = 0; i < this.childNodes.size(); i++) {
            if (i != this.childNodes.size() - 1) {
                if (start >= this.childNodes.get(i).getFullEnd() && end <= this.childNodes.get(i + 1).getFullStart()) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    protected int findSyntaxTokenInsertIndex(int start, int end) {
        if (this.childTokens.size() == 0) {
            return 0;
        }
        if (end < this.childTokens.get(0).getFullStart()) {
            return 0;
        }
        for (int i = 0; i < this.childTokens.size(); i++) {
            if (i != this.childTokens.size() - 1) {
                if (start >= this.childTokens.get(i).getFullEnd() && end <= this.childTokens.get(i + 1).getFullStart()) {
                    return i + 1;
                }
            }
        }
        if (start >= this.childTokens.get(this.childTokens.size() - 1).getFullEnd()) {
            return this.childTokens.size();
        }
        return -1;
    }

    public List<SyntaxNodeOrToken> getDescendNodeOrTokens() {
        ArrayList<SyntaxNodeOrToken> result = new ArrayList<>();
        result.addAll(this.getDescendNodes());
        result.addAll(this.getDescendTokens());
        return result;
    }

    public List<SyntaxNodeOrToken> getDescendNodeOrTokensAndSelf() {
        ArrayList<SyntaxNodeOrToken> result = new ArrayList<>();
        result.add(this);
        result.addAll(this.getDescendNodeOrTokens());
        return result;
    }
}
