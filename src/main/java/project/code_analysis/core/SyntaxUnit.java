package project.code_analysis.core;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
    private boolean missing;
    private boolean unexpected;
    private boolean error;

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
        throw new NotImplementedException();
    }

    public void setError(boolean missing, boolean unexpected) {
        this.missing = missing;
        this.unexpected = unexpected;
        this.error = missing || unexpected;
    }

    public ISyntaxKind getKind() {
        return kind;
    }

    public void setKind(ISyntaxKind kind) {
        this.kind = kind;
    }

    public boolean isMissing() {
        return missing;
    }

    public void setMissing(boolean missing) {
        this.missing = missing;
        this.setError(missing || this.error);
    }

    public boolean isUnexpected() {
        return unexpected;
    }

    public void setUnexpected(boolean unexpected) {
        this.unexpected = unexpected;
        this.setError(missing || this.error);
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        if (!error) {
            this.unexpected = false;
            this.missing = false;
        }
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
