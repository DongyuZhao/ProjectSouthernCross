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
public class BiggerToken extends SyntaxToken {
    public BiggerToken() {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN);
    }

    public BiggerToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, missing, unexpected);
    }

    public BiggerToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, missing, unexpected);
    }

    public BiggerToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, end, missing, unexpected);
    }

    public BiggerToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public BiggerToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public BiggerToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, missing, unexpected, parent);
    }

    public BiggerToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, missing, unexpected, parent);
    }

    public BiggerToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, end, missing, unexpected, parent);
    }

    public BiggerToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public BiggerToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
