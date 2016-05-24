package project.southern_cross.code_analysis;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public abstract class SyntaxNodeBuilder<T extends SyntaxNode> {
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();
    private ArrayList<SyntaxNode> childNodes = new ArrayList<>();
    private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
    private ArrayList<SyntaxTrivia> trialingTrivia = new ArrayList<>();
    private SyntaxNodeBuildRule<T> rule;
    private T node;

    public void clear() {
        this.childNodes.clear();
        this.childTokens.clear();
    }

    public void appendChildToken(SyntaxToken token) {
        this.childTokens.add(token);
        this.rule.updateNode();
    }

    public void appendChildNode(SyntaxNode node) {
        this.childNodes.add(node);
        this.rule.updateNode();
    }

    public void appendLeadingTrivia(SyntaxTrivia trivia) {
        this.leadingTrivia.add(trivia);
        this.rule.updateNode();
    }

    public void appendTrialingTrivia(SyntaxTrivia trivia) {
        this.trialingTrivia.add(trivia);
        this.rule.updateNode();
    }

    public void specifiedRule(SyntaxNodeBuildRule<T> rule) {
        this.rule = rule;
        this.rule.setContext(this);
    }

    public T getNode() {
        return this.node;
    }

    public SyntaxNodeBuilder() {
        this.node = (T) new SyntaxNode(null, 0, 0, 0, 0, SyntaxKind.Undetermined, false);
    }
}
