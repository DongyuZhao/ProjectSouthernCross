package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class CRLFToken extends TweetQlSyntaxToken {
    public CRLFToken() {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN);
    }

    public CRLFToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, missing, unexpected);
    }

    public CRLFToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, missing, unexpected);
    }

    public CRLFToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, missing, unexpected, parent);
    }

    public CRLFToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CRLF, TweetQlSyntaxTokenKind.CRLF_TOKEN, start, missing, unexpected, parent);
    }
}
