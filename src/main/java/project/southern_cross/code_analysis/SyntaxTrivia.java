package project.southern_cross.code_analysis;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxTrivia extends SyntaxUnit {
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();

    public SyntaxTrivia() {
        super();
    }

    public SyntaxTrivia(int start) {
        super(start);
    }

    public SyntaxTrivia(int start, int end) {
        super(start, end);
    }

    public SyntaxTrivia(int start, int end, int fullEnd) {
        super(start, end, fullEnd);
    }

    public SyntaxTrivia(int start, int end, int fullStart, int fullEnd) {
        super(start, end, fullStart, fullEnd);
    }

    public SyntaxTrivia(SyntaxNode parent) {
        super(parent);
    }

    public SyntaxTrivia(SyntaxNode parent, int start) {
        super(parent, start);
    }

    public SyntaxTrivia(SyntaxNode parent, int start, int end) {
        super(parent, start, end);
    }

    public SyntaxTrivia(SyntaxNode parent, int start, int end, int fullEnd) {
        super(parent, start, end, fullEnd);
    }

    public SyntaxTrivia(SyntaxNode parent, int start, int end, int fullStart, int fullEnd) {
        super(parent, start, end, fullStart, fullEnd);
    }
}
