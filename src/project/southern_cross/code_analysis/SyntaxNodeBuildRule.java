package project.southern_cross.code_analysis;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public abstract class SyntaxNodeBuildRule<T extends SyntaxNode> {
    protected SyntaxNodeBuilder<T> buildContext;

//    protected ArrayList<SyntaxNode> getChildNodes() {
//        return this.buildContext.getChildNodes();
//    }

    protected ArrayList<SyntaxToken> getChildToken() {
        return this.buildContext.getChildTokens();
    }

    protected ArrayList<SyntaxTrivia> getLeadingTrivia() {
        return  this.buildContext.getLeadingTrivia();
    }

    protected ArrayList<SyntaxTrivia> getTrialingTrivia() {
        return this.buildContext.getTrialingTrivia();
    }

    public void setContext(SyntaxNodeBuilder context) {
        this.buildContext = context;
    }

//    protected SyntaxNode getLastChildNodes() {
//        return this.getChildNodes().get(this.getChildNodes().size());
//    }

    protected SyntaxToken getLastChildTokens() {
        return this.getChildToken().get(this.getChildToken().size());
    }

    protected SyntaxTrivia getLastLeadingTrivia() {
        return  this.getLeadingTrivia().get(this.getLeadingTrivia().size());
    }

    protected SyntaxTrivia getLastTrialingTrivia() {
        return this.getTrialingTrivia().get(this.getTrialingTrivia().size());
    }
    public abstract void build();
}
