package project.code_analysis.core;

/**
 * The basic class of all of the syntax trivia
 */
public class SyntaxTrivia extends SyntaxNode {
    private SyntaxToken parentToken;

    /**
     * Get a new instance of syntax trivia
     * @param language the language of this trivia
     * @param kind the kind of this trivia
     */
    public SyntaxTrivia(String language, ISyntaxKind kind) {
        super(language, kind);
    }

    /**
     * Get a new instance of syntax trivia
     * @param language the language of this trivia
     * @param kind the kind of this trivia
     * @param error the error indicator
     */
    public SyntaxTrivia(String language, ISyntaxKind kind, SyntaxError error) {
        super(language, kind, error);
    }

    /**
     * Get a new instance of syntax trivia
     * @param language the language of this trivia
     * @param kind the kind of this trivia
     * @param start the start position of this trivia
     * @param error the error indicator
     */
    public SyntaxTrivia(String language, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, kind, start, error);
    }

    /**
     * Get a new instance of syntax trivia
     * @param language the language of this trivia
     * @param kind the kind of this trivia
     * @param parent the parent node of this trivia
     * @param error the error indicator
     */
    public SyntaxTrivia(String language, ISyntaxKind kind, SyntaxNodeOrToken parent, SyntaxError error) {
        super(language, kind, error);
        if (parent.isSyntaxNode()) {
            this.setParentNode((SyntaxNode) parent);
        } else {
            this.parentToken = (SyntaxToken) parent;
        }
    }

    /**
     * Get a new instance of syntax trivia
     * @param language the language of this trivia
     * @param kind the kind of this trivia
     * @param parent the parent node of this trivia
     * @param start the start position of this trivia
     * @param error the error indicator
     */
    public SyntaxTrivia(String language, ISyntaxKind kind, SyntaxNodeOrToken parent, int start, SyntaxError error) {
        super(language, kind, start, error);
        if (parent.isSyntaxNode()) {
            this.setParentNode((SyntaxNode) parent);
        } else {
            this.parentToken = (SyntaxToken) parent;
        }
    }

    public SyntaxNodeOrToken getParent() {
        if (this.parentToken != null) {
            return this.parentToken;
        } else {
            return this.getParentNode();
        }
    }

    public void setParent(SyntaxNodeOrToken parent) {
        if (parent.isSyntaxNode()) {
            this.setParentNode((SyntaxNode) parent);
        } else if (parent.isSyntaxToken()) {
            this.parentToken = (SyntaxToken) parent;
        }
    }
}
