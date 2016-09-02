package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/25.
 */
public class SyntaxTrivia extends SyntaxNode {
    private SyntaxToken parentToken;
    public SyntaxTrivia(String language, ISyntaxKind kind) {
        super(language, kind);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, SyntaxError error) {
        super(language, kind, error);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, kind, start, error);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, SyntaxNodeOrToken parent, SyntaxError error) {
        super(language, kind, error);
        if (parent.isSyntaxNode()) {
            this.setParentNode((SyntaxNode) parent);
        } else {
            this.parentToken = (SyntaxToken) parent;
        }
    }

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
