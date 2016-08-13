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
public class SyntaxUnit {

    private SyntaxNode parentNode;

    private SyntaxSpan span;
    private SyntaxSpan fullSpan;
    private ISyntaxKind kind;
    private boolean missing;
    private boolean unexpected;
    private boolean error;

    public SyntaxUnit() {
        this.parentNode = null;
        this.span = new SyntaxSpan(-1, -1);
        this.fullSpan = new SyntaxSpan(-1, -1);
    }

    public SyntaxUnit(int start) {
        this.parentNode = null;
        this.span = new SyntaxSpan(start, start);
        this.fullSpan = new SyntaxSpan(start, start);
    }

    public SyntaxUnit(int start, int end) {
        this.parentNode = null;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(start, end);
    }

    public SyntaxUnit(int start, int end, int fullEnd) {
        this.parentNode = null;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(start, fullEnd);
    }

    public SyntaxUnit(int start, int end, int fullStart, int fullEnd) {
        this.parentNode = null;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(fullStart, fullEnd);
    }

    public SyntaxUnit(SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(-1, -1);
        this.fullSpan = new SyntaxSpan(-1, -1);
    }

    public SyntaxUnit(int start, SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, start);
        this.fullSpan = new SyntaxSpan(start, start);
    }

    public SyntaxUnit(int start, int end, SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(start, end);
    }

    public SyntaxUnit(int start, int end, int fullEnd, SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(start, fullEnd);
    }

    public SyntaxUnit(int start, int end, int fullStart, int fullEnd, SyntaxNode parentNode) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(fullStart, fullEnd);
    }

    public SyntaxNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(SyntaxNode parentNode) {
        this.parentNode = parentNode;
    }

    public int getStart() {
        return span.getStart();
    }

    public void setStart(int start) {
        if (start <= this.getEnd()) {
            if (start < this.getFullStart()) {
                this.setFullStart(start);
            }
            this.span.setStart(start);
        } else {
            throw new IllegalArgumentException("The argument 'start' is greater than 'end'.");
        }
    }

    public int getEnd() {
        return span.getEnd();
    }

    public void setEnd(int end) {
        if (end >= this.getStart()) {
            if (end >= this.getFullEnd()) {
                this.setFullEnd(end);
            }
            this.span.setEnd(end);
        } else {
            throw new IllegalArgumentException("The argument 'end' is less than 'start'.");
        }
    }

    public int getFullStart() {
        return this.fullSpan.getStart();
    }

    public void setFullStart(int start) {
        if (start < this.getEnd()) {
            this.fullSpan.setStart(start);
        } else {
            throw new IllegalArgumentException("The argument 'start' is greater than 'end'.");
        }
    }

    public int getFullEnd() {
        return this.fullSpan.getEnd();
    }

    public void setFullEnd(int end) {
        if (end >= this.getStart()) {
            this.fullSpan.setEnd(end);
        } else {
            throw new IllegalArgumentException("The argument 'end' is less than 'start'.");
        }
    }

    public void shiftWindow(int offset) {
        this.span.shiftWindow(offset);
        this.fullSpan.shiftWindow(offset);
    }

    public void shiftFullSpanWindowTo(int offset) {
        this.shiftWindow(offset - this.getFullStart());
    }

//    public void shiftSpanWindowTo(int offset) {
//        this.shiftWindow(offset - this.getStart());
//    }

    public List<SyntaxNode> getAncestorNode() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        SyntaxNode node = this.getParentNode();
        if (node != null) {
            result.add(node);
            result.addAll(node.getAncestorNode());
        }
        return result;
    }

    public String getRawString() {
        throw new NotImplementedException();
    }

    public String getFullString() {
        StringBuilder builder = new StringBuilder();
        int startCount = this.getStart() - this.getFullStart();
        for (int i = 0; i < startCount; i++) {
            builder.append(' ');
        }
        builder.append(this.getRawString());
        int endCount = this.getFullEnd() - this.getEnd();
        for (int i = 0; i < endCount; i++) {
            builder.append(' ');
        }
        return builder.toString();
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

    public boolean isSyntaxNode() {
        return false;
    }

    public boolean isSyntaxToken() {
        return false;
    }

    public boolean isSyntaxTrivia() {
        return false;
    }
}
