package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * garentee.
 *
 * Created by Dy.Zhao on 2016/8/25.
 */
public class SyntaxTrivia extends SyntaxNode {
    public SyntaxTrivia(String language, ISyntaxKind kind) {
        super(language, kind);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(language, kind, missing, unexpected);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(language, kind, start, missing, unexpected);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(language, kind, missing, unexpected, parent);
    }

    public SyntaxTrivia(String language, ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(language, kind, start, missing, unexpected, parent);
    }
}
