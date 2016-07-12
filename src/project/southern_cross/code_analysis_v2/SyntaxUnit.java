package project.southern_cross.code_analysis_v2;

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

    public SyntaxUnit(SyntaxNode parentNode, int start) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, start);
        this.fullSpan = new SyntaxSpan(start, start);
    }

    public SyntaxUnit(SyntaxNode parentNode, int start, int end) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(start, end);
    }

    public SyntaxUnit(SyntaxNode parentNode, int start, int end, int fullEnd) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(start, fullEnd);
    }

    public SyntaxUnit(SyntaxNode parentNode, int start, int end, int fullStart, int fullEnd) {
        this.parentNode = parentNode;
        this.span = new SyntaxSpan(start, end);
        this.fullSpan = new SyntaxSpan(fullStart, fullEnd);
    }

    protected void setParentNode(SyntaxNode parentNode) {
        this.parentNode = parentNode;
    }

    public SyntaxNode getParentNode() {
        return parentNode;
    }

    public int getStart() {
        return span.getStart();
    }

    public int getEnd() {
        return span.getEnd();
    }

    protected void setStart(int start) {
        if (start < this.getStart()) {
            this.span.setStart(start);
            this.setFullStart(start);
        }
    }

    protected void setEnd(int end) {
        if (end >= this.getStart()) {
            if (end >= this.getEnd()) {
                this.span.setEnd(end);
                this.setFullEnd(end);
            }
        } else {
            throw new IllegalArgumentException("The argument 'end' is less than 'start'.");
        }
    }

    public int getFullStart() {
        return this.fullSpan.getStart();
    }

    public int getFullEnd() {
        return this.fullSpan.getEnd();
    }

    protected void setFullStart(int start) {
        if (start < this.getFullStart()) {
            this.fullSpan.setStart(start);
        }
    }

    protected void setFullEnd(int end) {
        if (end >= this.getFullStart()) {
            if (end >= this.getFullEnd()) {
                this.fullSpan.setEnd(end);
            }
        } else {
            throw new IllegalArgumentException("The argument 'end' is less than 'start'.");
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
}
