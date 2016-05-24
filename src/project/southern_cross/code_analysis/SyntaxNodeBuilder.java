package project.southern_cross.code_analysis;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public abstract class SyntaxNodeBuilder<T extends SyntaxNode> {

    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();
    //private ArrayList<SyntaxNode> childNodes = new ArrayList<>();
    private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
    private ArrayList<SyntaxTrivia> trialingTrivia = new ArrayList<>();
    private SyntaxNodeBuildRule<T> rule;
    private Span span = new Span();
    private Span fullSpan = new Span();
    private SyntaxNode parent;
    private boolean built = false;
    private T node;

    public void clear() {
        // this.childNodes.clear();
        this.childTokens.clear();
    }

    public void appendChildToken(SyntaxToken token) {
        this.childTokens.add(token);
        this.built = false;
        //this.rule.updateChildToken();
        this.span.updateEnd(token.fullSpan().end());
    }

    public void appendChildNode(SyntaxNode node) {
        this.getNode().addChildNode(node);
        this.built = false;
        //this.rule.updateChildNode();
        this.span.updateEnd(node.fullSpan().end());
    }

    public void appendLeadingTrivia(SyntaxTrivia trivia) {
        this.leadingTrivia.add(trivia);
        this.built = false;
        //this.rule.updateLeadingTrivia();
    }

    public void appendTrialingTrivia(SyntaxTrivia trivia) {
        this.trialingTrivia.add(trivia);
        this.built = false;
        //this.rule.updateTrialingTrivia();
    }

    public void specifiedRule(SyntaxNodeBuildRule<T> rule) {
        this.rule = rule;
        this.built = false;
        this.rule.setContext(this);
    }

    public T getNode() {
        if (!this.built) {
            this.rule.build();
            this.built = true;
        }
        return this.node;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public Span getSpan() {
        return span;
    }

    public Span getFullSpan() {
        return fullSpan;
    }

    public ArrayList<SyntaxToken> getChildTokens() {
        return childTokens;
    }

//    public ArrayList<SyntaxNode> getChildNodes() {
//        return childNodes;
//    }

    public ArrayList<SyntaxTrivia> getLeadingTrivia() {
        return leadingTrivia;
    }

    public ArrayList<SyntaxTrivia> getTrialingTrivia() {
        return trialingTrivia;
    }

    public SyntaxNodeBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        this.node = (T) new SyntaxNode(parent, startSpan, 0, startFullSpan, 0, SyntaxKind.Undetermined, false);
    }
}
