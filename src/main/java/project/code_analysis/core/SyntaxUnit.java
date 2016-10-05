package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The common root of all of the element that could used to construct abstract syntax tree
 */
public abstract class SyntaxUnit {

    private SyntaxNode parentNode;

    private int offset = 0;
    private String language;
    private ISyntaxKind kind;
    private SyntaxError error;

    /**
     * Construct a new instance
     * @param language the language name
     */
    public SyntaxUnit(String language) {
        this.parentNode = null;
        this.language = language;
    }

    /**
     * Construct a new instance
     * @param language the language name
     * @param offset the offset of this unit
     */
    public SyntaxUnit(String language, int offset) {
        this.parentNode = null;
        this.language = language;
        this.shiftWindow(offset);
    }

    /**
     * Shift this unit's full start with given offset
     * @param offset the given offset
     */
    public void shiftWindow(int offset) {
        this.offset += offset;
    }

    /**
     * Construct a new instance
     * @param language the language name
     * @param parentNode the parent node of this unit
     */
    public SyntaxUnit(String language, SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.language = language;
    }

    /**
     * Construct a new instance
     * @param language the language name
     * @param parentNode the parent node of this unit
     * @param offset the offset of this unit
     */
    public SyntaxUnit(String language, SyntaxNode parentNode, int offset) {
        this.parentNode = parentNode;
        this.language = language;
        this.shiftWindow(offset);
    }

    /**
     * Get the parent node of this unit
     * @return the parent node of this unit
     */
    public SyntaxNode getParentNode() {
        return parentNode;
    }

    /**
     * Set the parent node of this unit
     * @param parentNode the parent node of this unit
     */
    public void setParentNode(SyntaxNode parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * Get the root of the syntax tree this syntax unit in
     * @return the root of the syntax tree this syntax unit in
     */
    public SyntaxNode getRootNode() {
        if (this.getParentNode() != null) {
            return this.parentNode.getRootNode();
        } else {
            if (this.isSyntaxNode()) {
                return (SyntaxNode) this;
            } else {
                return null;
            }
        }
    }

    /**
     * Get the ancestor nodes of this syntax unit
     * @return the ancestor nodes of this syntax unit
     */
    public List<SyntaxNode> getAncestorNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        SyntaxNode node = this.getParentNode();
        if (node != null) {
            result.add(node);
            result.addAll(node.getAncestorNodes());
        }
        return result;
    }

    @Override
    public String toString() {
        return "SyntaxUnit";
    }

    /**
     * Get the kind of this unit
     * @return the kind of this unit
     */
    public ISyntaxKind getKind() {
        return this.kind;
    }

    /**
     * Set the kind of this unit
     * @param kind the kind of this unit
     */
    public void setKind(ISyntaxKind kind) {
        this.kind = kind;
    }

    /**
     * Get if this unit is missing
     * @return if this unit is missing
     */
    public boolean isMissing() {
        return this.error.isMissing();
    }

    /**
     * Set if this unit is missing
     * @param missing if this unit is missing
     */
    public void setMissing(boolean missing) {
        this.error.setMissing(missing);
    }

    /**
     * Get if this unit is unexpected
     * @return if this unit is unexpected
     */
    public boolean isUnexpected() {
        return this.error.isUnexpected();
    }

    /**
     * Set if this unit is unexpected
     * @param unexpected if this unit is unexpected
     */
    public void setUnexpected(boolean unexpected) {
        this.error.setUnexpected(unexpected);
    }

    /**
     * Get if this unit contains error
     * @return if this unit contains error
     */
    public boolean isError() {
        return this.error.isError();
    }

    /**
     * Set if this unit contains error
     * @param error if this unit contains error
     */
    public void setError(SyntaxError error) {
        this.error = error;
    }

    /**
     * Get the language name of this syntax unit
     * @return the language name of this syntax unit
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Get the span of this unit
     * @return the span of this unit
     */
    public SyntaxSpan getSpan() {
        return new SyntaxSpan(this.getStart(), this.getEnd());
    }

    /**
     * Get the start position of this unit without the leading trivia of this unit
     * @return the start position of this unit without the leading trivia of this unit
     */
    public int getStart() {
        return this.offset + this.getLeadingTriviaLength();
    }

    /**
     * Get the end position of this unit without the trialing trivia of this unit
     * @return the end position of this unit without the trialing trivia of this unit
     */
    public int getEnd() {
        return this.getStart() + this.getLength();
    }

    /**
     * Get the length of all of the leading trivia of this unit
     * @return the length of all of the leading trivia of this unit
     */
    public int getLeadingTriviaLength() {
        return 0;
    }

    /**
     * Get the length of this unit without trivia
     * @return the length of this unit without trivia
     */
    public int getLength() {
        return 0;
    }

    /**
     * Get the length of all of the leading trivia of this unit
     * @return the length of all of the leading trivia of this unit
     */
    public SyntaxSpan getFullSpan() {
        return new SyntaxSpan(this.getFullStart(), this.getFullEnd());
    }

    /**
     * Get the start position of this unit includes all of its leading trivia
     * @return the start position of this unit includes all of its leading trivia
     */
    public int getFullStart() {
        return this.offset;
    }

    /**
     * Get the end position of this unit includes all of its leading trivia
     * @return the end position of this unit includes all of its leading trivia
     */
    public int getFullEnd() {
        return this.getFullStart() + this.getFullLength();
    }

    /**
     * Get the length of this all of the trivia
     * @return the length of this all of the trivia
     */
    public int getFullLength() {
        return this.getLeadingTriviaLength() + this.getLength() + this.getTrialingTriviaLength();
    }

    /**
     * Get the length of all of the trialing trivia of this unit
     * @return the length of all of the trialing trivia of this unit
     */
    public int getTrialingTriviaLength() {
        return 0;
    }

    /**
     * Shift this unit's full start to given position
     * @param position the given position
     */
    public void shiftWindowTo(int position) {
        int offset = position - this.getFullStart();
        this.shiftWindow(offset);
    }

    /**
     * Get if this unit is a syntax node
     * @return if this unit is a syntax node
     */
    public boolean isSyntaxNode() {
        return false;
    }

    /**
     * Get if this unit is a syntax token
     * @return if this unit is a syntax token
     */
    public boolean isSyntaxToken() {
        return false;
    }

    /**
     * Get if this unit is a syntax trivia
     * @return if this unit is a syntax trivia
     */
    public boolean isSyntaxTrivia() {
        return false;
    }

    /**
     * Get the plain text this unit without trivia represents
     * @return the plain text this unit without trivia represents
     */
    public abstract String getRawString();

    /**
     * Get the plain text this unit with all of the trivia represents
     * @return the plain text this unit with all of the trivia represents
     */
    public abstract String getFullString();
}
