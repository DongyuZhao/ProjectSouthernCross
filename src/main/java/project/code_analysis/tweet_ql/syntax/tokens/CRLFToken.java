package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class CRLFToken extends SyntaxToken {
    public CRLFToken() {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN);
    }

    public CRLFToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, missing, unexpected);
    }

    public CRLFToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, missing, unexpected);
    }

    public CRLFToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, end, missing, unexpected);
    }

    public CRLFToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public CRLFToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CRLFToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, missing, unexpected, parent);
    }

    public CRLFToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, missing, unexpected, parent);
    }

    public CRLFToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, end, missing, unexpected, parent);
    }

    public CRLFToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public CRLFToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
