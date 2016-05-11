package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxToken extends SyntaxNodeOrToken {

    public SyntaxToken(SyntaxNode parent, String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, SyntaxKind kind) {
        super(parent, rawString, spanStart, spanEnd, fullSpanStart, fullSpanEnd, kind);
    }

}
