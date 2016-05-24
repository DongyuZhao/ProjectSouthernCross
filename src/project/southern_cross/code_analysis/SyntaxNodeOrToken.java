package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxNodeOrToken {
    private Span span = new Span();
    private Span fullSpan = new Span();

    private SyntaxNode parent;

    private int kind;

    private SyntaxTrivia leadingTrivia;

    private SyntaxTrivia trialingTrivia;

    public SyntaxNodeOrToken(SyntaxNode parent, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind) {
        this.parent = parent;
        this.span = new Span(spanStart, spanEnd);
        this.fullSpan = new Span(fullSpanStart, fullSpanEnd);
        this.kind = kind;
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

    void setParent(SyntaxNode _parent) {
        this.parent = _parent;
    }

    public void setKind(int _kind) {
        this.kind = _kind;
    }

    void setLeadingTrivia(SyntaxTrivia _leadingTrivia) {
        this.leadingTrivia = _leadingTrivia;
    }

    void setTrialingTrivia(SyntaxTrivia _trialingTrivia) {
        this.trialingTrivia = _trialingTrivia;
    }
}
