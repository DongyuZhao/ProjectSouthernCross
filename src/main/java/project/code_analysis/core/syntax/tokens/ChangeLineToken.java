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
public class ChangeLineToken extends SyntaxToken {
    public ChangeLineToken(String language, String rawString) {
        super(language, rawString, AbstractSyntaxKind.CHANGE_LINE_TOKEN);
    }

    public ChangeLineToken(String language, String rawString, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.CHANGE_LINE_TOKEN, missing, unexpected);
    }

    public ChangeLineToken(String language, String rawString, int start, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.CHANGE_LINE_TOKEN, start, missing, unexpected);
    }

    public ChangeLineToken(String language, String rawString, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.CHANGE_LINE_TOKEN, parent, missing, unexpected);
    }

    public ChangeLineToken(String language, String rawString, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(language, rawString, AbstractSyntaxKind.CHANGE_LINE_TOKEN, parent, start, missing, unexpected);
    }
}
