package project.southern_cross.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxToken extends SyntaxNodeOrToken {

    private final String rawString;

    private SyntaxTrivia parentTrivia;

    public SyntaxToken(String rawString, int kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, int kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, int kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String rawString, int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(SyntaxNode parent, String rawString, int kind, boolean missing, boolean unexpected) {
        super(parent, kind, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(SyntaxNode parent, String rawString, int kind, int start, boolean missing, boolean unexpected) {
        super(parent, kind, start, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(SyntaxNode parent, String rawString, int kind, int start, int end, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(SyntaxNode parent, String rawString, int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullEnd, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(SyntaxNode parent, String rawString, int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullStart, fullEnd, missing, unexpected);
        this.rawString = rawString;
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
}
