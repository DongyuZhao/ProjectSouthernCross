package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public abstract class SyntaxUnit {

    private SyntaxNode parentNode;

    private int offset = 0;
    private String language;
    private ISyntaxKind kind;
    private SyntaxError error;

    public SyntaxUnit(String language) {
        this.parentNode = null;
        this.language = language;
    }

    public SyntaxUnit(String language, int offset) {
        this.parentNode = null;
        this.language = language;
    }

    public SyntaxUnit(String language, SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.language = language;
    }

    public SyntaxUnit(String language, SyntaxNode parentNode, int offset) {
        this.parentNode = parentNode;
        this.language = language;
    }

    public SyntaxNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(SyntaxNode parentNode) {
        this.parentNode = parentNode;
    }

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

    public List<SyntaxNode> getAncestorNode() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        SyntaxNode node = this.getParentNode();
        if (node != null) {
            result.add(node);
            result.addAll(node.getAncestorNode());
        }
        return result;
    }

    @Override
    public String toString() {
        return "SyntaxUnit";
    }

    public ISyntaxKind getKind() {
        return kind;
    }

    public void setKind(ISyntaxKind kind) {
        this.kind = kind;
    }

    public boolean isMissing() {
        return this.error.isMissing();
    }

    public void setMissing(boolean missing) {
        this.error.setMissing(missing);
    }

    public boolean isUnexpected() {
        return this.error.isUnexpected();
    }

    public void setUnexpected(boolean unexpected) {
        this.error.setUnexpected(unexpected);
    }

    public boolean isError() {
        return this.error.isError();
    }

    public void setError(SyntaxError error) {
        this.error = error;
    }

    public String getLanguage() {
        return language;
    }

    public SyntaxSpan getSpan() {
        return new SyntaxSpan(this.getStart(), this.getEnd());
    }

    public int getStart() {
        return this.offset + this.getLeadingTriviaLength();
    }

    public int getEnd() {
        return this.getStart() + this.getLength();
    }

    public int getLeadingTriviaLength() {
        return 0;
    }

    public int getLength() {
        return 0;
    }

    public SyntaxSpan getFullSpan() {
        return new SyntaxSpan(this.getFullStart(), this.getFullEnd());
    }

    public int getFullStart() {
        return this.offset;
    }

    public int getFullEnd() {
        return this.getFullStart() + this.getFullLength();
    }

    public int getFullLength() {
        return this.getLeadingTriviaLength() + this.getLength() + this.getTrialingTriviaLength();
    }

    public int getTrialingTriviaLength() {
        return 0;
    }

    public void shiftWindowTo(int position) {
        int offset = position - this.getFullStart();
        this.shiftWindow(offset);
    }

    public void shiftWindow(int offset) {
        this.offset += offset;
    }

    public boolean isSyntaxNode() {
        return false;
    }

    public boolean isSyntaxToken() {
        return false;
    }

    public boolean isSyntaxTrivia() {
        return false;
    }

    public abstract String getRawString();

    public abstract String getFullString();
}
