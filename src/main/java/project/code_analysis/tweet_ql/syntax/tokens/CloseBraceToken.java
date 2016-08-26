package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseBraceToken extends TweetQlSyntaxToken {
    public CloseBraceToken() {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlSyntaxTokenKind.CLOSE_BRACE_TOKEN);
    }

    public CloseBraceToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlSyntaxTokenKind.CLOSE_BRACE_TOKEN, missing, unexpected);
    }

    public CloseBraceToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlSyntaxTokenKind.CLOSE_BRACE_TOKEN, start, missing, unexpected);
    }

    public CloseBraceToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlSyntaxTokenKind.CLOSE_BRACE_TOKEN, parent, missing, unexpected);
    }

    public CloseBraceToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlSyntaxTokenKind.CLOSE_BRACE_TOKEN, parent, start, missing, unexpected);
    }
}
