package project.code_analysis.core.syntax.builders;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;

import java.util.ArrayList;

/**
 * An abstract class that all of the syntax builders should implement
 */
public abstract class AbstractSyntaxNodeBuilder<T extends SyntaxNode> {
    protected T root;

    protected ArrayList<SyntaxToken> tokenList = new ArrayList<>();

    /**
     * Append the given token into this builder
     *
     * @param token the given token
     */
    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    /**
     * Clear the builder to its initial state
     */
    public void clear() {
        this.tokenList.clear();
    }

    /**
     * Build the syntax token list to its corresponded syntax node
     *
     * @return the corresponded syntax node of the syntax tokens append to this builder
     */
    public abstract T build();
}
