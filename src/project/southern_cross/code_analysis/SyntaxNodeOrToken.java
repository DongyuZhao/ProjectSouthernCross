package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxNodeOrToken {
    private Span span = new Span();
    private Span fullSpan = new Span();

    private SyntaxNode parent;

    private int kind;

    private SyntaxTrivia leadingTrivia;

    private SyntaxTrivia trialingTrivia;

    private boolean isMissing;

    private boolean isUnexpected;

    private boolean withError;

    public SyntaxNodeOrToken(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind, boolean isMissing, boolean isUnexpected, boolean withError) {
        this.parent = parent;
        this.span = new Span(spanStart, spanEnd);
        this.fullSpan = new Span(fullSpanStart, fullSpanEnd);
        this.kind = kind;
        this.isMissing = isMissing;
        this.isUnexpected = isUnexpected;
        this.withError = withError;
    }

    public Span span() {
        return span;
    }

    public Span fullSpan() {
        return fullSpan;
    }

    public SyntaxNode parent() {
        return parent;
    }

    public int kind() {
        return this.kind;
    }

    public SyntaxTrivia leadingTrivia() {
        return leadingTrivia;
    }

    public SyntaxTrivia trialingTrivia() {
        return trialingTrivia;
    }

    void setParent(SyntaxNode parent) {
        this.parent = parent;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    void setLeadingTrivia(SyntaxTrivia leadingTrivia) {
        this.leadingTrivia = leadingTrivia;
    }

    void setTrialingTrivia(SyntaxTrivia trialingTrivia) {
        this.trialingTrivia = trialingTrivia;
    }

    public boolean isMissing() {
        return this.isMissing;
    }

    public boolean isUnexpected() { return  this.isUnexpected; }

    public void setMissing(boolean isMissing) {
        this.isMissing = isMissing;
    }

    public void setUnexpected(boolean isUnexpected) {
        this.isUnexpected = isUnexpected;
    }

    public boolean isWithError() {
        return withError;
    }

    public void setWithError(boolean withError) {
        this.withError = withError;
    }
}
