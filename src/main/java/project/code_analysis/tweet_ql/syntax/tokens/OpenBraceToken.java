package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OpenBraceToken extends TweetQlSyntaxToken {
    public OpenBraceToken() {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE);
    }

    public OpenBraceToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, missing, unexpected);
    }

    public OpenBraceToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, start, missing, unexpected);
    }

    public OpenBraceToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, parent, missing, unexpected);
    }

    public OpenBraceToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, parent, start, missing, unexpected);
    }
}
