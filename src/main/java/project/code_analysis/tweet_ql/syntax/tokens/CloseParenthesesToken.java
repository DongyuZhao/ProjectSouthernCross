package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseParenthesesToken extends TweetQlSyntaxToken {
    public CloseParenthesesToken() {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES);
    }

    public CloseParenthesesToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, missing, unexpected);
    }

    public CloseParenthesesToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, start, missing, unexpected);
    }

    public CloseParenthesesToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, parent, missing, unexpected);
    }

    public CloseParenthesesToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, parent, start, missing, unexpected);
    }
}
