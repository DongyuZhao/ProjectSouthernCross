package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The basic class of all of the syntax nodes
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNodeOrToken> children = new ArrayList<>();

    /**
     * Get a new instance of syntax node
     * @param language the language of this node
     * @param kind the kind of this node
     */
    public SyntaxNode(String language, ISyntaxKind kind) {
        super(language, kind);
    }

    /**
     * Get a new instance of syntax node
     * @param language the language of this node
     * @param kind the kind of this node
     * @param error the error indicator
     */
    public SyntaxNode(String language, ISyntaxKind kind, SyntaxError error) {
        super(language, kind, error);
    }

    /**
     * Get a new instance of syntax node
     * @param language the language of this node
     * @param kind the kind of this node
     * @param start the start position of this node
     * @param error the error indicator
     */
    public SyntaxNode(String language, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, kind, start, error);
    }

    /**
     * Get a new instance of syntax node
     * @param language the language of this node
     * @param kind the kind of this node
     * @param parent the parent node of this node
     * @param error the error indicator
     */
    public SyntaxNode(String language, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(language, kind, parent, error);
    }

    /**
     * Get a new instance of syntax node
     * @param language the language of this node
     * @param kind the kind of this node
     * @param parent the parent node of this node
     * @param start the start position of this node
     * @param error the error indicator
     */
    public SyntaxNode(String language, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(language, kind, parent, start, error);
    }

    /**
     * Get if this node has child nodes
     * @return if this node has child nodes
     */
    public boolean hasChildNode() {
        return this.getChildNodeCount() != 0;
    }

    /**
     * Get the amount of child nodes this node have
     * @return the amount of child nodes this node have
     */
    public int getChildNodeCount() {
        return (int) this.children.stream().filter(SyntaxUnit::isSyntaxNode).count();
    }

    /**
     * Get if this node has child tokens
     * @return if this node has child tokens
     */
    public boolean hasChildToken() {
        return this.getChildTokenCount() != 0;
    }

    /**
     * Get the amount of child tokens this node have
     * @return the amount of child nodes this node have
     */
    public int getChildTokenCount() {
        return (int) this.children.stream().filter(SyntaxUnit::isSyntaxToken).count();
    }

    /**
     * Add the given token into this node
     * @param token the given token
     */
    public void addChildToken(SyntaxToken token) {
        token.setParentNode(this);
        token.shiftWindowTo(this.getSpan().getEnd());
        this.children.add(token);
    }

    /**
     * Add the given node into this node
     * @param node the given node
     */
    public void addChildNode(SyntaxNode node) {
        node.setParentNode(this);
        node.shiftWindowTo(this.getSpan().getEnd());
        this.children.add(node);
    }

    /**
     * Get a list of all of the child tokens of this node
     * @return the list of all of the child tokens of this node
     */
    public List<SyntaxToken> getChildTokens() {
        ArrayList<SyntaxToken> result = new ArrayList<>();
        this.children.stream().filter(SyntaxUnit::isSyntaxToken).forEach(t -> result.add((SyntaxToken) t));
        return result;
    }

    /**
     * Get a list of all of children of this node
     * @return the list of all of children of this node
     */
    public List<SyntaxNodeOrToken> getChildNodesOrTokens() {
        return this.children.stream().collect(Collectors.toList());
    }

    /**
     * Get a list of all of descent nodes of this node
     * @return the list of all of descent nodes of this node
     */
    public List<SyntaxNode> getDescentNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        this.children.stream().filter(SyntaxUnit::isSyntaxNode).forEach(t -> result.add((SyntaxNode) t));
        for (int i = 0; i < result.size(); i++) {
            result.addAll(result.get(i).getChildNodes());
        }
        return result;
    }

    /**
     * Get a list of all of the child nodes of this node
     * @return the list of all of the child nodes of this node
     */
    public List<SyntaxNode> getChildNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        this.children.stream().filter(SyntaxUnit::isSyntaxNode).forEach(t -> result.add((SyntaxNode) t));
        return result;
    }

    /**
     * Get a list of all of descent nodes and itself of this node
     * @return the list of all of descent nodes and itself of this node
     */
    public List<SyntaxNode> getDescentNodesOrSelf() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        result.add(this);
        for (int i = 0; i < result.size(); i++) {
            result.addAll(result.get(i).getChildNodes());
        }
        return result;
    }

    /**
     * Replace the given target node with the given new node
     * @param target the given target node
     * @param newNode the given new node
     */
    public void replaceNode(SyntaxNode target, SyntaxNode newNode) {
        int index = this.children.indexOf(target);
        if (index >= 0) {
            this.children.set(index, newNode);
            newNode.setParentNode(this);
        }
    }

    @Override
    public String toString() {
        return this.getFullString();
    }

    @Override
    public void shiftWindow(int offset) {
        super.shiftWindow(offset);
        this.children.forEach(u -> u.shiftWindow(offset));
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
