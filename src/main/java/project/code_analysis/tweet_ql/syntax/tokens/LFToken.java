package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class LFToken extends TweetQlSyntaxToken {
    public LFToken() {
        super(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN);
    }

    public LFToken( boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN, missing, unexpected);
    }

    public LFToken( int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN, start, missing, unexpected);
    }

    public LFToken( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN, missing, unexpected, parent);
    }

    public LFToken( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxTokenKind.LF_TOKEN, start, missing, unexpected, parent);
    }
}
