package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class LFToken extends TweetQlSyntaxToken {
    public LFToken() {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN);
    }

    public LFToken( boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, missing, unexpected);
    }

    public LFToken( int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, start, missing, unexpected);
    }

    public LFToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, parent, missing, unexpected);
    }

    public LFToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, parent, start, missing, unexpected);
    }
}
