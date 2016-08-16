package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class SelectExpressionSyntax extends SyntaxNode {
    public SelectExpressionSyntax() {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN);
    }

    public SelectExpressionSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, missing, unexpected);
    }

    public SelectExpressionSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public SelectExpressionSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, end, missing, unexpected);
    }

    public SelectExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public SelectExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public SelectExpressionSyntax(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public SelectExpressionSyntax(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }

    public SelectExpressionSyntax(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, end, missing, unexpected, parent);
    }

    public SelectExpressionSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public SelectExpressionSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }

    @Override
    public String getRawString() {
        return "SELECT";
    }
}
