package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class LessEqualToken extends TweetQlSyntaxToken {
    public LessEqualToken() {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN);
    }

    public LessEqualToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN, missing, unexpected);
    }

    public LessEqualToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN, start, missing, unexpected);
    }

    public LessEqualToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN, parent, missing, unexpected);
    }

    public LessEqualToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxTokenKind.LESS_EQUAL_TOKEN, parent, start, missing, unexpected);
    }
}
