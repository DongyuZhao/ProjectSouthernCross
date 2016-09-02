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
public class BiggerEqualToken extends TweetQlSyntaxToken {
    public BiggerEqualToken() {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN);
    }

    public BiggerEqualToken(SyntaxError error) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, error);
    }

    public BiggerEqualToken(int start, SyntaxError error) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, start, error);
    }

    public BiggerEqualToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, parent, error);
    }

    public BiggerEqualToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, parent, start, error);
    }
}
