package project.southern_cross.code_analysis.tweet_ql.syntax;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.boot.BootLoader;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
public class CreateExpressionSyntax extends SyntaxNode {
    public CreateExpressionSyntax(boolean missing, boolean unexpected) {
        super(BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), missing, unexpected);
    }

    public CreateExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, end, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, end, fullEnd, missing, unexpected);
    }

    public CreateExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(parent, BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(parent, BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, int end, boolean missing, boolean unexpected) {
        super(parent, BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, end, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, end, fullEnd, missing, unexpected);
    }

    public CreateExpressionSyntax(SyntaxNode parent, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, BootLoader.getSyntaxFacts("tweet_ql").getSyntaxKind("Create_Node"), start, end, fullStart, fullEnd, missing, unexpected);
    }

    @Override
    public String getRawString() {
        return super.getRawString();
    }

    @Override
    public String getFullString() {
        return super.getFullString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
