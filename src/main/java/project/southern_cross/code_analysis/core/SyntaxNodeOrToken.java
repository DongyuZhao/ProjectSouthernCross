package project.southern_cross.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNodeOrToken extends SyntaxUnit {

    public SyntaxNodeOrToken(int kind, boolean missing, boolean unexpected) {
        super();
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(int kind, int start, boolean missing, boolean unexpected) {
        super(start);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(int kind, int start, int end, boolean missing, boolean unexpected) {
        super(start, end);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(start, end, fullEnd);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(start, end, fullStart, fullEnd);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(SyntaxNode parent, int kind, boolean missing, boolean unexpected) {
        super(parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(SyntaxNode parent, int kind, int start, boolean missing, boolean unexpected) {
        super(parent, start);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(SyntaxNode parent, int kind, int start, int end, boolean missing, boolean unexpected) {
        super(parent, start, end);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(SyntaxNode parent, int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, start, end, fullEnd);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(SyntaxNode parent, int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, start, end, fullStart, fullEnd);
        this.setKind(kind);
        setError(missing, unexpected);
    }
}
