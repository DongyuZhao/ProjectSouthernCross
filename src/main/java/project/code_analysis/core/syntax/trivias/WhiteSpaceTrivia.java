package project.code_analysis.core.syntax.trivias;

import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.core.SyntaxTrivia;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public class WhiteSpaceTrivia extends SyntaxTrivia {
    private int length;

    public WhiteSpaceTrivia(String language, int length) {
        super(language, AbstractSyntaxKind.WHITE_SPACE_TRIVIA);
        if (length >= 0) {
            this.length = length;
        }
    }

    public WhiteSpaceTrivia(String language, int length, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.WHITE_SPACE_TRIVIA, missing, unexpected);
        if (length >= 0) {
            this.length = length;
        }
    }

    public WhiteSpaceTrivia(String language, int length, int start, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.WHITE_SPACE_TRIVIA, start, missing, unexpected);
        if (length >= 0) {
            this.length = length;
        }
    }

    public WhiteSpaceTrivia(String language, int length, SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.WHITE_SPACE_TRIVIA, parent, missing, unexpected);
        if (length >= 0) {
            this.length = length;
        }
    }

    public WhiteSpaceTrivia(String language, int length, SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(language, AbstractSyntaxKind.WHITE_SPACE_TRIVIA, parent, start, missing, unexpected);
        if (length >= 0) {
            this.length = length;
        }
    }

    @Override
    public int getFullLength() {
        return this.getLength();
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String getRawString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    @Override
    public String getFullString() {
        return this.getRawString();
    }
}
