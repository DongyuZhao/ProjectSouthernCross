package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseBraceToken extends TweetQlSyntaxToken {
    public CloseBraceToken() {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE);
    }

    public CloseBraceToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, missing, unexpected);
    }

    public CloseBraceToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, start, missing, unexpected);
    }

    public CloseBraceToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, parent, missing, unexpected);
    }

    public CloseBraceToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, parent, start, missing, unexpected);
    }
}
