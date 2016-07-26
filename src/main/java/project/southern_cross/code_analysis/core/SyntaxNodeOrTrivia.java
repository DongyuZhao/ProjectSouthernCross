package project.southern_cross.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/26.
 */
public class SyntaxNodeOrTrivia extends SyntaxNodeOrToken {

    protected ArrayList<SyntaxToken> childTokens = new ArrayList<>();

    public SyntaxNodeOrTrivia(int kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(int kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(int kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(SyntaxNode parent, int kind, boolean missing, boolean unexpected) {
        super(parent, kind, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(SyntaxNode parent, int kind, int start, boolean missing, boolean unexpected) {
        super(parent, kind, start, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(SyntaxNode parent, int kind, int start, int end, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(SyntaxNode parent, int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullEnd, missing, unexpected);
    }

    public SyntaxNodeOrTrivia(SyntaxNode parent, int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public List<SyntaxToken> getChildTokens() {
        return this.childTokens;
    }

    public void addChildToken(SyntaxToken token) {
        this.addChildToken(token, this.childTokens.size());
    }

    public void addChildToken(SyntaxToken token, int index) {
        if (index >= 0 && index <= this.getChildTokens().size()) {
            if (index == 0) {
                if (this.getStart() > token.getStart()) {
                    token.shiftFullSpanWindowTo(this.getStart());
                }
                this.childTokens.add(token);
            } else {
                token.shiftFullSpanWindowTo(this.childTokens.get(index - 1).getFullEnd());
            }

            if (index < this.getChildTokens().size()) {
                this.updateSpanWindow(index, token.getRawString().length(), this.childTokens);
            }
            this.childTokens.add(index, token);
            return;
        }
        throw new IllegalArgumentException("Index out of range");
    }

    protected void updateSpanWindow(int index, int length, List<? extends SyntaxUnit> container) {
        if (length < 0) {
            throw new IllegalArgumentException("length should be greater than 0");
        }
        if (index >= container.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        List<? extends SyntaxUnit> targetList = container.subList(index, container.size() - 1);
        targetList.forEach(target -> {
            target.shiftWindow(length);
        });
    }

    protected int findSyntaxUnitInsertIndex(int start, int end, List<? extends SyntaxUnit> container) {
        if (container.size() == 0) {
            return 0;
        }
        if (end < container.get(0).getFullStart()) {
            return 0;
        }
        if (start >= container.get(container.size() - 1).getFullEnd()) {
            return container.size();
        }
        for (int i = 0; i < container.size(); i++) {
            if (i != container.size() - 1) {
                if (start >= container.get(i).getFullEnd() && end <= container.get(i + 1).getFullStart()) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    @Override
    protected void shiftWindow(int offset) {
        this.getChildTokens().forEach(token -> token.shiftWindow(offset));
        super.shiftWindow(offset);
    }

    @Override
    protected void shiftFullSpanWindowTo(int offset) {
        this.getChildTokens().forEach(token -> token.shiftFullSpanWindowTo(offset));
        super.shiftFullSpanWindowTo(offset);
    }

//    @Override
//    protected void shiftSpanWindowTo(int offset) {
//        this.getChildTokens().forEach(token -> token.shiftSpanWindowTo(offset));
//        super.shiftSpanWindowTo(offset);
//    }
}
