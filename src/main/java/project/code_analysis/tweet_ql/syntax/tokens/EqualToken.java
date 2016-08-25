package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class EqualToken extends TweetQlSyntaxToken {
    public EqualToken() {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN);
    }

    public EqualToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN, missing, unexpected);
    }

    public EqualToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN, start, missing, unexpected);
    }

    public EqualToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN, missing, unexpected, parent);
    }

    public EqualToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN, start, missing, unexpected, parent);
    }
}
