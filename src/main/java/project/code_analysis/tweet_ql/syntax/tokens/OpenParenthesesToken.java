package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OpenParenthesesToken extends TweetQlSyntaxToken {
    public OpenParenthesesToken() {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES);
    }

    public OpenParenthesesToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, missing, unexpected);
    }

    public OpenParenthesesToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, start, missing, unexpected);
    }

    public OpenParenthesesToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, parent, missing, unexpected);
    }

    public OpenParenthesesToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, parent, start, missing, unexpected);
    }
}
