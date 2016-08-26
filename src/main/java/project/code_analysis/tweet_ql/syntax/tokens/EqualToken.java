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

    public EqualToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN, parent, missing, unexpected);
    }

    public EqualToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxTokenKind.EQUAL_TOKEN, parent, start, missing, unexpected);
    }
}
