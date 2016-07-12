package project.southern_cross.code_analysis_v2;

import jdk.nashorn.internal.runtime.regexp.joni.Syntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNodeOrToken extends SyntaxUnit {

    private int kind;

    private boolean missing;
    private boolean unexpected;
    private boolean error;
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

    protected void setError(boolean missing, boolean unexpected) {
        this.missing = missing;
        this.unexpected = unexpected;
        this.error = missing || unexpected;
    }


    public int getKind() {
        return kind;
    }

    protected void setKind(int kind) {
        this.kind = kind;
    }

    public boolean isMissing() {
        return missing;
    }

    protected void setMissing(boolean missing) {
        this.missing = missing;
        this.setError(missing || this.error);
    }

    public boolean isUnexpected() {
        return unexpected;
    }

    protected void setUnexpected(boolean unexpected) {
        this.unexpected = unexpected;
        this.setError(missing || this.error);
    }

    public boolean isError() {
        return error;
    }

    protected void setError(boolean error) {
        this.error = error;
    }
}
