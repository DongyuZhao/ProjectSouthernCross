package project.code_analysis.core.syntax.tokens;

import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public class CommentsTextToken extends SyntaxToken {
    public CommentsTextToken(String language, String rawString) {
        super(language, rawString, AbstractSyntaxKind.COMMENTS_TEXT_TOKEN);
    }

    public CommentsTextToken(String language, String rawString, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.COMMENTS_TEXT_TOKEN, missing, unexpected);
    }

    public CommentsTextToken(String language, String rawString, int start, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.COMMENTS_TEXT_TOKEN, start, missing, unexpected);
    }

    public CommentsTextToken(String language, String rawString, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.COMMENTS_TEXT_TOKEN, parent, missing, unexpected);
    }

    public CommentsTextToken(String language, String rawString, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.COMMENTS_TEXT_TOKEN, parent, start, missing, unexpected);
    }
}
