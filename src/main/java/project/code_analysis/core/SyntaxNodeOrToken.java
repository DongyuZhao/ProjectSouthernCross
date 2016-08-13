package project.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNodeOrToken extends SyntaxUnit {
    public SyntaxNodeOrToken(ISyntaxKind kind) {
        super();
        this.setKind(kind);
        this.setError(false, false);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super();
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(start);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected) {
        super(start, end);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(start, end, fullEnd);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(start, end, fullStart, fullEnd);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(start, parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(start, end, parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(start, end, fullEnd, parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(start, end, fullStart, fullEnd, parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }
}
