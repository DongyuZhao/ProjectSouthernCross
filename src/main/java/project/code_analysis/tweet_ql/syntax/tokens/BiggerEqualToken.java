package project.code_analysis.tweet_ql.syntax.tokens;

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

    public BiggerEqualToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, missing, unexpected);
    }

    public BiggerEqualToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, start, missing, unexpected);
    }

    public BiggerEqualToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, parent, missing, unexpected);
    }

    public BiggerEqualToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlTokenKind.BIGGER_EQUAL_TOKEN, parent, start, missing, unexpected);
    }
}
