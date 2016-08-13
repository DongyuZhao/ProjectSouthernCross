package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class LFToken extends SyntaxToken {
    public LFToken() {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN);
    }

    public LFToken( boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, missing, unexpected);
    }

    public LFToken( int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, missing, unexpected);
    }

    public LFToken( int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, end, missing, unexpected);
    }

    public LFToken( int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public LFToken( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public LFToken( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, missing, unexpected, parent);
    }

    public LFToken( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, missing, unexpected, parent);
    }

    public LFToken( int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, end, missing, unexpected, parent);
    }

    public LFToken( int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public LFToken( int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LF, TweetQlSyntaxKind.LF_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
