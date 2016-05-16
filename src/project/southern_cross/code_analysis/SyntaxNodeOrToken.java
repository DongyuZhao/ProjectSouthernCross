package project.southern_cross.code_analysis;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxNodeOrToken {
    private Span _span = new Span();
    private Span _fullSpan = new Span();

    private SyntaxNode _parent;

    private int _kind;

    private String _rawString;

    private SyntaxTrivia _leadingTrivia;

    private SyntaxTrivia _trialingTrivia;

    public SyntaxNodeOrToken(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, int kind) {
        this._parent = parent;
        this._span = new Span(spanStart, spanEnd);
        this._fullSpan = new Span(fullSpanStart, fullSpanEnd);
        this._kind = kind;
        this._rawString = rawString;
    }

    public Span span() {
        return _span;
    }

    public Span fullSpan() {
        return _fullSpan;
    }

    public SyntaxNode parent() {
        return _parent;
    }

    public SyntaxKind kind() {
        return SyntaxFacts.getKind(this._kind);
    }

    public String rawString() {
        return _rawString;
    }

    public SyntaxTrivia leadingTrivia() {
        return _leadingTrivia;
    }

    public SyntaxTrivia trialingTrivia() {
        return _trialingTrivia;
    }
}
