package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
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

    public OpenParenthesesToken(SyntaxError error) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, error);
    }

    public OpenParenthesesToken(int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, start, error);
    }

    public OpenParenthesesToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, parent, error);
    }

    public OpenParenthesesToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_PARENTHESES, TweetQlTokenKind.OPEN_PARENTHESES, parent, start, error);
    }
}
