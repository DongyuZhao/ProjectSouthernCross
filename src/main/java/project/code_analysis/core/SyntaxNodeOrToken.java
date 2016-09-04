package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

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
        this.setError(SyntaxError.getNoError());
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxError error) {
        super(language);
        this.setKind(kind);
        setError(error);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, start);
        this.setKind(kind);
        setError(error);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(language, parent);
        this.setKind(kind);
        setError(error);
    }

    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(language, parent, start);
        this.setKind(kind);
        setError(error);
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
    public String toString() {
        return this.getClass().getName() + ":\t" + this.getRawString();
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

    public List<SyntaxTrivia> getLeadingTrivia() {
        return leadingTrivia;
    }

    public List<SyntaxTrivia> getTrialingTrivia() {
        return trialingTrivia;
    }
}
