package project.code_analysis;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxTrivia extends SyntaxNodeOrTrivia {
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();

    public SyntaxTrivia() {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, false, false);
    }

    public SyntaxTrivia(int start) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, false, false);
    }

    public SyntaxTrivia(int start, int end) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, end, false, false);
    }

    public SyntaxTrivia(int start, int end, int fullEnd) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, end, fullEnd, false, false);
    }

    public SyntaxTrivia(int start, int end, int fullStart, int fullEnd) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, end, fullStart, fullEnd, false, false);
    }

    public SyntaxTrivia(SyntaxNode parent) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, false, false, parent);
    }

    public SyntaxTrivia(SyntaxNode parent, int start) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, false, false, parent);
    }

    public SyntaxTrivia(SyntaxNode parent, int start, int end) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, end, false, false, parent);
    }

    public SyntaxTrivia(SyntaxNode parent, int start, int end, int fullEnd) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, end, fullEnd, false, false, parent);
    }

    public SyntaxTrivia(SyntaxNode parent, int start, int end, int fullStart, int fullEnd) {
        super(AbstractSyntaxKind.SYNTAX_TRIVIA, start, end, fullStart, fullEnd, false, false, parent);
    }
}
