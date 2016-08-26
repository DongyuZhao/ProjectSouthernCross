package project.code_analysis.core;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public abstract class SyntaxNodeOrToken extends SyntaxUnit {
    private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
    private ArrayList<SyntaxTrivia> trialingTrivia = new ArrayList<>();

    public SyntaxNodeOrToken(String language, ISyntaxKind kind) {
        super(language);
        this.setKind(kind);
        this.setError(false, false);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(language);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(language, start);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(language, parent);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(language, parent, start);
        this.setKind(kind);
        setError(missing, unexpected);
    }

    public void addLeadingTrivia(SyntaxTrivia trivia) {
        trivia.setParent(this);
        trivia.shiftWindowTo(this.getStart());
        this.leadingTrivia.add(trivia);
    }

    public void addTrialingTrivia(SyntaxTrivia trivia) {
        trivia.setParent(this);
        trivia.shiftWindowTo(this.getFullSpan().getEnd());
        this.trialingTrivia.add(trivia);
    }

    @Override
    public int getLeadingTriviaLength() {
        int result = 0;
        for (SyntaxTrivia syntaxTrivia : this.leadingTrivia) {
            result += syntaxTrivia.getFullLength();
        }
        return result;
    }

    @Override
    public int getTrialingTriviaLength() {
        int result = 0;
        for (SyntaxTrivia syntaxTrivia : this.trialingTrivia) {
            result += syntaxTrivia.getFullLength();
        }
        return result;
    }

    @Override
    public void shiftWindow(int offset) {
        this.leadingTrivia.forEach(t -> t.shiftWindow(offset));
        this.trialingTrivia.forEach(t -> t.shiftWindow(offset));
        super.shiftWindow(offset);
    }

    @Override
    public String getFullString() {
        return this.getLeadingTriviaString() +
                this.getRawString() +
                this.getTrialingTriviaString();
    }

    public String getLeadingTriviaString() {
        StringBuilder builder = new StringBuilder();
        this.leadingTrivia.forEach(t -> builder.append(t.getFullString()));
        return builder.toString();
    }

    public String getTrialingTriviaString() {
        StringBuilder builder = new StringBuilder();
        this.trialingTrivia.forEach(t -> builder.append(t.getFullString()));
        return builder.toString();
    }
}
