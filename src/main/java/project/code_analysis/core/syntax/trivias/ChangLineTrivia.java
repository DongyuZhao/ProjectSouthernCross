package project.code_analysis.core.syntax.trivias;

import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.core.SyntaxTrivia;
import project.code_analysis.core.syntax.tokens.ChangeLineToken;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public class ChangLineTrivia extends SyntaxTrivia {
    public ChangLineTrivia(String language, ChangeLineToken token) {
        super(language, AbstractSyntaxKind.CHANGE_LINE_TRIVIA);
    }

    public ChangLineTrivia(String language, ChangeLineToken token, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.CHANGE_LINE_TRIVIA, missing, unexpected);
        this.addChildToken(token);
    }

    public ChangLineTrivia(String language, ChangeLineToken token, int start, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.CHANGE_LINE_TRIVIA, start, missing, unexpected);
        this.addChildToken(token);
    }

    public ChangLineTrivia(String language, ChangeLineToken token, SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.CHANGE_LINE_TRIVIA, parent, missing, unexpected);
        this.addChildToken(token);
    }

    public ChangLineTrivia(String language, ChangeLineToken token, SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.CHANGE_LINE_TRIVIA, parent, start, missing, unexpected);
        this.addChildToken(token);
    }
}
