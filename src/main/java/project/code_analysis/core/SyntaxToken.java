package project.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxToken extends SyntaxNodeOrToken {

    private final String rawString;

    private SyntaxTrivia parentTrivia;

    public SyntaxToken(String rawString, ISyntaxKind kind) {
        super(kind);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, missing, unexpected, parent);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, missing, unexpected, parent);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, missing, unexpected, parent);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, fullEnd, missing, unexpected, parent);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected, parent);
        this.rawString = rawString;
    }

    @Override
    public boolean isSyntaxToken() {
        return true;
    }

    @Override
    public String getRawString() {
        return this.rawString;
    }

    @Override
    public String toString() {
        return "SyntaxToken: " + this.getFullString();
    }

    public void setParentTrivia(SyntaxTrivia trivia) {
        this.parentTrivia = trivia;
    }

    public SyntaxTrivia getParentTrivia() {
        return this.parentTrivia;
    }
}
