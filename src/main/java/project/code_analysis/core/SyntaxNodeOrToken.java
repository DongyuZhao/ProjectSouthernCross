package project.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The common parent of all of the syntax nodes and syntax tokens
 */
public abstract class SyntaxNodeOrToken extends SyntaxUnit {
    private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
    private ArrayList<SyntaxTrivia> trialingTrivia = new ArrayList<>();

    /**
     * Get a new instance of syntax node or token
     * @param language the language of this unit
     * @param kind the kind of this unit
     */
    public SyntaxNodeOrToken(String language, ISyntaxKind kind) {
        super(language);
        this.setKind(kind);
        this.setError(SyntaxError.getNoError());
    }

    /**
     * Get a new instance of syntax node or token
     * @param language the language of this unit
     * @param kind the kind of this unit
     * @param error the error indicator
     */
    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxError error) {
        super(language);
        this.setKind(kind);
        setError(error);
    }

    /**
     * Get a new instance of syntax node or token
     * @param language the language of this unit
     * @param kind the kind of this unit
     * @param start the start position of this unit
     * @param error the error indicator
     */
    public SyntaxNodeOrToken(String language, ISyntaxKind kind, int start, SyntaxError error) {
        super(language, start);
        this.setKind(kind);
        setError(error);
    }

    /**
     * Get a new instance of syntax node or token
     * @param language the language of this unit
     * @param kind the kind of this unit
     * @param parent the parent node of this unit
     * @param error the error indicator
     */
    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(language, parent);
        this.setKind(kind);
        setError(error);
    }

    /**
     * Get a new instance of syntax node or token
     * @param language the language of this unit
     * @param kind the kind of this unit
     * @param parent the parent node of this unit
     * @param start the start position of this unit
     * @param error the error indicator
     */
    public SyntaxNodeOrToken(String language, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(language, parent, start);
        this.setKind(kind);
        setError(error);
    }

    /**
     * Add the given leading trivia to this unit
     * @param trivia the given leading trivia
     */
    public void addLeadingTrivia(SyntaxTrivia trivia) {
        trivia.setParent(this);
        trivia.shiftWindowTo(this.getStart());
        this.leadingTrivia.add(trivia);
    }

    /**
     * Add the given trialing trivia to this unit
     * @param trivia the given trialing trivia
     */
    public void addTrialingTrivia(SyntaxTrivia trivia) {
        trivia.setParent(this);
        trivia.shiftWindowTo(this.getFullSpan().getEnd());
        this.trialingTrivia.add(trivia);
    }

    @Override
    public void shiftWindow(int offset) {
        this.leadingTrivia.forEach(t -> t.shiftWindow(offset));
        this.trialingTrivia.forEach(t -> t.shiftWindow(offset));
        super.shiftWindow(offset);
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
    public String getFullString() {
        return this.getLeadingTriviaString() +
                this.getRawString() +
                this.getTrialingTriviaString();
    }

    /**
     * Get the string represent the leading trivia
     * @return the string represent the leading trivia
     */
    public String getLeadingTriviaString() {
        StringBuilder builder = new StringBuilder();
        this.leadingTrivia.forEach(t -> builder.append(t.getFullString()));
        return builder.toString();
    }

    /**
     * Get the string represent the trialing trivia
     * @return the string represent the trialing trivia
     */
    public String getTrialingTriviaString() {
        StringBuilder builder = new StringBuilder();
        this.trialingTrivia.forEach(t -> builder.append(t.getFullString()));
        return builder.toString();
    }

    /**
     * Get a list of this unit's leading trivia
     * @return the list of this unit's leading trivia
     */
    public List<SyntaxTrivia> getLeadingTrivia() {
        return this.leadingTrivia;
    }

    /**
     * Get a list of this unit's trialing trivia
     * @return the list of this unit's trialing trivia
     */
    public List<SyntaxTrivia> getTrialingTrivia() {
        return this.trialingTrivia;
    }
}
