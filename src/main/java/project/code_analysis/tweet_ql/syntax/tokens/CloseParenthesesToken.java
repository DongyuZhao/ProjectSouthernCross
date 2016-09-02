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
public class CloseParenthesesToken extends TweetQlSyntaxToken {
    public CloseParenthesesToken() {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES);
    }

    public CloseParenthesesToken(SyntaxError error) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, error);
    }

    public CloseParenthesesToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, start, error);
    }

    public CloseParenthesesToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, parent, error);
    }

    public CloseParenthesesToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_PARENTHESES, TweetQlTokenKind.CLOSE_PARENTHESES, parent, start, error);
    }
}
