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
public class BiggerEqualToken extends SyntaxToken {
    public BiggerEqualToken() {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN);
    }

    public BiggerEqualToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, missing, unexpected);
    }

    public BiggerEqualToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, missing, unexpected);
    }

    public BiggerEqualToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, end, missing, unexpected);
    }

    public BiggerEqualToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public BiggerEqualToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public BiggerEqualToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, missing, unexpected, parent);
    }

    public BiggerEqualToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, missing, unexpected, parent);
    }

    public BiggerEqualToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, end, missing, unexpected, parent);
    }

    public BiggerEqualToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public BiggerEqualToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER_EQUAL, TweetQlSyntaxTokenKind.BIGGER_EQUAL_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
