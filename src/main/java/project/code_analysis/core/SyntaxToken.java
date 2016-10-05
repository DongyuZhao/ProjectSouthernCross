package project.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */

/**
 * The basic class of all of the syntax tokens
 */
public class SyntaxToken extends SyntaxNodeOrToken {

    private final String rawString;

    /**
     * Get a new instance of syntax token
     * @param language the language of this token
     * @param rawString the plain text this token will hold
     * @param kind the kind of this token
     */
    public SyntaxToken(String language, String rawString, ISyntaxKind kind) {
        super(language, kind);
        this.rawString = rawString;
    }

    /**
     * Get a new instance of syntax token
     * @param language the language of this token
     * @param rawString the plain text this token will hold
     * @param kind the kind of this token
     * @param error the error indicator
     */
    public SyntaxToken(String language, String rawString, ISyntaxKind kind, SyntaxError error) {
        super(language, kind, error);
        this.rawString = rawString;
    }

    /**
     * Get a new instance of syntax token
     * @param language the language of this token
     * @param rawString the plain text this token will hold
     * @param kind the kind of this token
     * @param start the start position of this token
     * @param error the error indicator
     */
    public SyntaxToken(String language, String rawString, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, kind, start, error);
        this.rawString = rawString;
    }

    /**
     * Get a new instance of syntax token
     * @param language the language of this token
     * @param rawString the plain text this token will hold
     * @param kind the kind of this token
     * @param parent the parent node of this token
     * @param error the error indicator
     */
    public SyntaxToken(String language, String rawString, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(language, kind, parent, error);
        this.rawString = rawString;
    }

    /**
     * Get a new instance of syntax token
     * @param language the language of this token
     * @param rawString the plain text this token will hold
     * @param kind the kind of this token
     * @param parent the parent node of this token
     * @param start the start position of this token
     * @param error the error indicator
     */
    public SyntaxToken(String language, String rawString, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(language, kind, parent, start, error);
        this.rawString = rawString;
    }

    @Override
    public String toString() {
        return "SyntaxToken: " + this.getRawString();
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
