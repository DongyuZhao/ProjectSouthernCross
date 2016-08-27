package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class CRLFToken extends TweetQlSyntaxToken {
    public CRLFToken() {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN);
    }

    public CRLFToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, missing, unexpected);
    }

    public CRLFToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, start, missing, unexpected);
    }

    public CRLFToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, parent, missing, unexpected);
    }

    public CRLFToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, parent, start, missing, unexpected);
    }
}
