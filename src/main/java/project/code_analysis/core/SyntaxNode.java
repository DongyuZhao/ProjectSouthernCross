package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNodeOrToken> children = new ArrayList<>();

    public SyntaxNode(String language, ISyntaxKind kind) {
        super(language, kind);
    }

    public SyntaxNode(String language, ISyntaxKind kind, SyntaxError error) {
        super(language, kind, error);
    }

    public SyntaxNode(String language, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, kind, start, error);
    }

    public SyntaxNode(String language, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(language, kind, parent, error);
    }

    public SyntaxNode(String language, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(language, kind, parent, start, error);
    }

    public boolean hasChildNode() {
        return this.getChildNodeCount() != 0;
    }

    public int getChildNodeCount() {
        return (int) this.children.stream().filter(SyntaxUnit::isSyntaxNode).count();
    }

    public boolean hasChildToken() {
        return this.getChildTokenCount() != 0;
    }

    public int getChildTokenCount() {
        return (int) this.children.stream().filter(SyntaxUnit::isSyntaxToken).count();
    }

    public void addChildToken(SyntaxToken token) {
        token.setParentNode(this);
        token.shiftWindowTo(this.getSpan().getEnd());
        this.children.add(token);
    }

    public void addChildNode(SyntaxNode node) {
        node.setParentNode(this);
        node.shiftWindowTo(this.getSpan().getEnd());
        this.children.add(node);
    }

    public List<SyntaxToken> getChildTokens() {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        this.children.stream().filter(SyntaxUnit::isSyntaxToken).forEach(t -> result.add((SyntaxToken) t));
        return result;
    }

    public List<SyntaxNodeOrToken> getChildNodesOrTokens() {
        return this.children.stream().collect(Collectors.toList());
    }

    public List<SyntaxNode> getDescentNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        this.children.stream().filter(SyntaxUnit::isSyntaxNode).forEach(t -> result.add((SyntaxNode) t));
        result.forEach(t -> result.addAll(t.getChildNodes()));
        return result;
    }

    public List<SyntaxNode> getChildNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        this.children.stream().filter(SyntaxUnit::isSyntaxNode).forEach(t -> result.add((SyntaxNode) t));
        return result;
    }

    public List<SyntaxNode> getDescentNodesOrSelf() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        result.add(this);
        result.forEach(t -> result.addAll(t.getChildNodes()));
        return result;
    }

    public void replaceNode(SyntaxNode target, SyntaxNode newValue) {
        int index = this.children.indexOf(target);
        if (index >= 0) {
            this.children.set(index, newValue);
            newValue.setParentNode(this);
        }
    }

    @Override
    public void shiftWindow(int offset) {
        super.shiftWindow(offset);
        this.children.forEach(u -> u.shiftWindow(offset));
    }

    @Override
    public String toString() {
        return this.getFullString();
    }

    @Override
    public int getLength() {
        int result = 0;
        for (SyntaxUnit child : this.children) {
            result += child.getFullLength();
        }
        return result;
    }

    @Override
    public boolean isSyntaxNode() {
        return true;
    }

    @Override
    public String getRawString() {
        StringBuilder builder = new StringBuilder();
        this.children.forEach(t -> builder.append(t.getFullString()));
        return builder.toString();
    }
}
