package project.southern_cross.code_analysis.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNode extends SyntaxNodeOrTrivia {

    private ArrayList<SyntaxNode> childNodes = new ArrayList<>();

    private ArrayList<SyntaxTrivia> leadingTrivia = new ArrayList<>();
    private ArrayList<SyntaxTrivia> trialingTrivia = new ArrayList<>();


    public SyntaxNode(int kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
    }

    public SyntaxNode(int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, boolean missing, boolean unexpected) {
        super(parent, kind, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, boolean missing, boolean unexpected) {
        super(parent, kind, start, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, int end, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullEnd, missing, unexpected);
    }

    public SyntaxNode(SyntaxNode parent, int kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public boolean hasChildNode() {
        return this.childNodes.size() != 0;
    }

//    public void addChildNode(SyntaxNode child) {
//        int index = this.findSyntaxUnitInsertIndex(child.getFullStart(), child.getFullEnd(), this.childNodes);
//        if (index != -1) {
//            this.addChildNode(child, index);
//            return;
//        }
//        throw new IllegalArgumentException("New SyntaxNode's position is not suitable for the existing nodes.");
//    }

    public List<SyntaxNode> getChildNodes() {
        return new ArrayList<>(this.childNodes);
    }

    public List<SyntaxNode> getDescendNodes() {
        ArrayList<SyntaxNode> result = new ArrayList<>(this.childNodes);
        for (int i = 0; i < result.size(); i++) {
            result.addAll(result.get(i).getChildNodes());
        }
        return result;
    }

    public List<SyntaxNode> getDescendNodesAndSelf() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        result.add(this);
        result.addAll(this.getDescendNodes());
        return result;
    }

    public List<SyntaxNode> getAncestorNodeAndSelf() {
        ArrayList<SyntaxNode> result = new ArrayList<>();
        result.add(this);
        result.addAll(this.getAncestorNode());
        return result;
    }

    public void addChildNode(SyntaxNode node) {
        this.addChildNode(node, this.getChildNodes().size());
    }

    public void addChildNode(SyntaxNode node, int index) {
        if (index >= 0 && index <= this.getChildNodes().size()) {
            node.setParentNode(this);
            if (index == 0) {
                if (this.getStart() > node.getStart()) {
                    node.shiftFullSpanWindowTo(this.getStart());
                }
                this.childNodes.add(node);
            } else {
                node.shiftFullSpanWindowTo(this.getChildNodes().get(index - 1).getFullEnd());
            }

            if (index < this.getChildNodes().size()) {
                this.updateSpanWindow(index, node.getRawString().length(), this.childNodes);
            }
            this.childNodes.add(index, node);
            this.updateSpanWindow(0, node.getRawString().length(), this.trialingTrivia);
            return;
        }
        throw new IllegalArgumentException("Index out of range");
    }

    public boolean hasChildToken() {
        return this.childTokens.size() != 0;
    }

    @Override
    public void addChildToken(SyntaxToken token, int index) {
        super.addChildToken(token, index);
        token.setParentNode(this);
        this.updateSpanWindow(0, token.getRawString().length(), this.trialingTrivia);
    }

    public List<SyntaxToken> getDescendTokens() {
        ArrayList<SyntaxToken> result = new ArrayList<>(this.childTokens);
        this.getDescendNodes().forEach(node -> result.addAll(node.getChildTokens()));
        return result;
    }

    public List<SyntaxNodeOrToken> getDescendNodeOrTokens() {
        ArrayList<SyntaxNodeOrToken> result = new ArrayList<>();
        result.addAll(this.getDescendNodes());
        result.addAll(this.getDescendTokens());
        return result;
    }

    public List<SyntaxNodeOrToken> getDescendNodeOrTokensAndSelf() {
        ArrayList<SyntaxNodeOrToken> result = new ArrayList<>();
        result.add(this);
        result.addAll(this.getDescendNodeOrTokens());
        return result;
    }

    public List<SyntaxTrivia> getLeadingTrivia() {
        return new ArrayList<>(this.leadingTrivia);
    }

    public List<SyntaxTrivia> getTrialingTrivia() {
        return new ArrayList<>(this.trialingTrivia);
    }

    public void addLeadingTrivia(SyntaxTrivia trivia, int index) {
        if (index >= 0 && index <= this.getLeadingTrivia().size()) {
            trivia.setParentNode(this);
            if (index == 0) {
                if (this.getStart() > trivia.getStart()) {
                    trivia.shiftFullSpanWindowTo(this.getStart());
                }
                this.leadingTrivia.add(trivia);
            } else {
                trivia.shiftFullSpanWindowTo(this.getLeadingTrivia().get(index - 1).getFullEnd());
            }

            if (index < this.getLeadingTrivia().size()) {
                this.updateSpanWindow(index, trivia.getRawString().length(), this.leadingTrivia);
            }
            this.leadingTrivia.add(index, trivia);
            this.updateSpanWindow(0, trivia.getRawString().length(), this.childNodes);
            this.updateSpanWindow(0, trivia.getRawString().length(), this.trialingTrivia);
            return;
        }
        throw new IllegalArgumentException("Index out of range");
    }

    public void addLeadingTrivia(SyntaxTrivia trivia) {
        this.addLeadingTrivia(trivia, this.getLeadingTrivia().size());
    }

    public void addTrialingTrivia(SyntaxTrivia trivia, int index) {
        if (index >= 0 && index <= this.getTrialingTrivia().size()) {
            trivia.setParentNode(this);
            if (index == 0) {
                if (this.getStart() > trivia.getStart()) {
                    trivia.shiftFullSpanWindowTo(this.getStart());
                }
                this.trialingTrivia.add(trivia);
            } else {
                trivia.shiftFullSpanWindowTo(this.getTrialingTrivia().get(index - 1).getFullEnd());
            }

            if (index < this.getTrialingTrivia().size()) {
                this.updateSpanWindow(index, trivia.getRawString().length(), this.leadingTrivia);
            }
            this.trialingTrivia.add(index, trivia);
            return;
        }
        throw new IllegalArgumentException("Index out of range");
    }

    public void addTrialingTrivia(SyntaxTrivia trivia) {
        this.addTrialingTrivia(trivia, this.getTrialingTrivia().size());
    }


    @Override
    public String toString() {
        if (this.hasChildNode()) {
            StringBuilder stringBuilder = new StringBuilder();
            this.getChildNodes().forEach(node -> stringBuilder.append(node.getFullString()));
            return "SyntaxNode: '" + stringBuilder.toString() + "';";
        }
        else {
            StringBuilder stringBuilder = new StringBuilder();
            // this.getLeadingTrivia().stream().forEach(trivia -> stringBuilder.append(trivia.getFullString()));
            this.getChildTokens().forEach(token -> stringBuilder.append(token.getFullString()));
            // this.getTrialingTrivia().forEach(trivia -> stringBuilder.append(trivia.getFullString()));
            return "SyntaxNode: '" + stringBuilder.toString() + "';";
        }
    }

    @Override
    public String getFullString() {
        StringBuilder builder = new StringBuilder();
        int startCount = this.getStart() - this.getFullStart();
        for (int i = 0; i < startCount; i++) {
            builder.append(' ');
        }
        if (this.hasChildNode()) {
            this.getChildNodes().forEach(node -> builder.append(node.getFullString()));
        }
        else {
            this.getLeadingTrivia().forEach(trivia -> builder.append(trivia.getFullString()));
            this.getChildTokens().forEach(token -> builder.append(token.getFullString()));
            this.getTrialingTrivia().forEach(trivia -> builder.append(trivia.getFullString()));
        }
        int endCount = this.getFullEnd() - this.getEnd();
        for (int i = 0; i < endCount; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }
}
