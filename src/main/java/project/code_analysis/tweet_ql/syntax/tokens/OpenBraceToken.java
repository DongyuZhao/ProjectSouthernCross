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
public class OpenBraceToken extends SyntaxToken {
    public OpenBraceToken() {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN);
    }

    public OpenBraceToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, missing, unexpected);
    }

    public OpenBraceToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, missing, unexpected);
    }

    public OpenBraceToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, end, missing, unexpected);
    }

    public OpenBraceToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public OpenBraceToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public OpenBraceToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, missing, unexpected, parent);
    }

    public OpenBraceToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, missing, unexpected, parent);
    }

    public OpenBraceToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, end, missing, unexpected, parent);
    }

    public OpenBraceToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public OpenBraceToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlSyntaxTokenKind.OPEN_BRACE_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
