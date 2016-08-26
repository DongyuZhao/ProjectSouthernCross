package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseParenthesesToken extends TweetQlSyntaxToken {
    public CloseParenthesesToken() {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN);
    }

    public CloseParenthesesToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, missing, unexpected);
    }

    public CloseParenthesesToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, start, missing, unexpected);
    }

    public CloseParenthesesToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, parent, missing, unexpected);
    }

    public CloseParenthesesToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlSyntaxTokenKind.CLOSE_PARENTHESES_TOKEN, parent, start, missing, unexpected);
    }
}
