package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class BiggerToken extends TweetQlSyntaxToken {
    public BiggerToken() {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN);
    }

    public BiggerToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, missing, unexpected);
    }

    public BiggerToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, start, missing, unexpected);
    }

    public BiggerToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, parent, missing, unexpected);
    }

    public BiggerToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BIGGER, TweetQlSyntaxTokenKind.BIGGER_TOKEN, parent, start, missing, unexpected);
    }
}
