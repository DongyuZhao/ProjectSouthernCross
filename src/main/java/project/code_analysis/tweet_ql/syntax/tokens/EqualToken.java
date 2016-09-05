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
public class EqualToken extends BinaryOperatorToken {
    public EqualToken() {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN);
    }

    public EqualToken(SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, error);
    }

    public EqualToken(int start, SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, start, error);
    }

    public EqualToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, parent, error);
    }

    public EqualToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.EQUAL, TweetQlTokenKind.EQUAL_TOKEN, parent, start, error);
    }
}
