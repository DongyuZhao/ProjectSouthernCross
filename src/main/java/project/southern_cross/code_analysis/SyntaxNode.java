package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxNode extends SyntaxNodeOrToken {

    private ArrayList<SyntaxNode> childNodes = new ArrayList<>();
    private ArrayList<SyntaxToken> childTokens = new ArrayList<>();

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

    public void addChildNode(SyntaxNode child) {
        int index = this.findSyntaxUnitInsertIndex(child.getFullStart(), child.getFullEnd(), this.childNodes);
        if (index != -1) {
            this.addChildNode(child, index);
            return;
        }
        throw new IllegalArgumentException("New SyntaxNode's position is not suitable for the existing nodes.");
    }

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

    public void addChildNode(SyntaxNode child, int index) {
        child.setParentNode(this);
        this.childNodes.add(index, child);
        this.setStart(child.getStart());
        this.setFullStart(child.getFullStart());
        this.setEnd(child.getEnd());
        this.setFullEnd(child.getFullEnd());
    }

    public boolean hasChildToken() {
        return this.childTokens.size() != 0;
    }

    public void addChildToken(SyntaxToken child) {
        int index = this.findSyntaxUnitInsertIndex(child.getFullStart(), child.getFullEnd(), this.childTokens);
        if (index != -1) {
            this.addChildToken(child, index);
            return;
        }
        throw new IllegalArgumentException("New SyntaxToken's position is not suitable for the existing nodes.");
    }

    public List<SyntaxToken> getChildTokens() {
        return new ArrayList<>(this.childTokens);
    }

    public List<SyntaxToken> getDescendTokens() {
        ArrayList<SyntaxToken> result = new ArrayList<>(this.childTokens);
        this.getDescendNodes().forEach(node -> result.addAll(node.getChildTokens()));
        return result;
    }

    public void addChildToken(SyntaxToken child, int index) {
        child.setParentNode(this);
        this.childTokens.add(index, child);
        this.setStart(child.getStart());
        this.setFullStart(child.getFullStart());
        this.setEnd(child.getEnd());
        this.setFullEnd(child.getFullEnd());
    }

    private int findSyntaxUnitInsertIndex(int start, int end, List<? extends SyntaxUnit> container) {
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

    public void addLeadingTrivia(SyntaxTrivia trivia) {
        int index = this.findSyntaxUnitInsertIndex(trivia.getFullStart(), trivia.getFullEnd(), this.leadingTrivia);
        if (index != -1) {
            this.addLeadingTrivia(trivia, index);
            return;
        }
        throw new IllegalArgumentException("New SyntaxTrivia's position is not suitable for the existing nodes.");
    }

    public void addLeadingTrivia(SyntaxTrivia trivia, int index) {
        trivia.setParentNode(this);
        this.leadingTrivia.add(index, trivia);
        this.setStart(trivia.getFullEnd());
        this.setFullStart(trivia.getFullStart());
        this.setEnd(trivia.getFullEnd());
        this.setFullEnd(trivia.getFullEnd());
    }

    public void addTrialingTrivia(SyntaxTrivia trivia) {
        int index = this.findSyntaxUnitInsertIndex(trivia.getFullStart(), trivia.getFullEnd(), this.trialingTrivia);
        if (index != -1) {
            this.addTrialingTrivia(trivia, index);
            return;
        }
        throw new IllegalArgumentException("New SyntaxTrivia's position is not suitable for the existing nodes.");
    }

    public void addTrialingTrivia(SyntaxTrivia trivia, int index) {
        trivia.setParentNode(this);
        this.trialingTrivia.add(index, trivia);
        this.setStart(trivia.getFullEnd());
        this.setFullStart(trivia.getFullStart());
        this.setEnd(trivia.getFullEnd());
        this.setFullEnd(trivia.getFullEnd());
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
