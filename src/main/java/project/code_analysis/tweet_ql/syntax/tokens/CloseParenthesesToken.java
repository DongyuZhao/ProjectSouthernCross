package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseParenthesesToken extends SyntaxToken {
    public CloseParenthesesToken() {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN);
    }

    public CloseParenthesesToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, missing, unexpected);
    }

    public CloseParenthesesToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, missing, unexpected);
    }

    public CloseParenthesesToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, end, missing, unexpected);
    }

    public CloseParenthesesToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public CloseParenthesesToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CloseParenthesesToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, missing, unexpected, parent);
    }

    public CloseParenthesesToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, missing, unexpected, parent);
    }

    public CloseParenthesesToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, end, missing, unexpected, parent);
    }

    public CloseParenthesesToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public CloseParenthesesToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
