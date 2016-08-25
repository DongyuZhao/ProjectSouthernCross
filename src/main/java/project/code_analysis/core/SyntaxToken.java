package project.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxToken extends SyntaxNodeOrToken {

    private final String rawString;

    public SyntaxToken(String language, String rawString, ISyntaxKind kind) {
        super(language, kind);
        this.rawString = rawString;
    }

    public SyntaxToken(String language, String rawString, ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(language, kind, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String language, String rawString, ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(language, kind, start, missing, unexpected);
        this.rawString = rawString;
    }

    public SyntaxToken(String language, String rawString, ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(language, kind, missing, unexpected, parent);
        this.rawString = rawString;
    }

    public SyntaxToken(String language, String rawString, ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(language, kind, start, missing, unexpected, parent);
        this.rawString = rawString;
    }

    @Override
    public String toString() {
        return "SyntaxToken: " + this.getFullString();
    }

    @Override
    public int getLength() {
        return this.rawString.length();
    }

    @Override
    public boolean isSyntaxToken() {
        return true;
    }

    @Override
    public String getRawString() {
        return this.rawString;
    }
}
