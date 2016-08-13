package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StarToken extends SyntaxToken {
    public StarToken() {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN);
    }

    public StarToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, missing, unexpected);
    }

    public StarToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, missing, unexpected);
    }

    public StarToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, end, missing, unexpected);
    }

    public StarToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public StarToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public StarToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, missing, unexpected, parent);
    }

    public StarToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, missing, unexpected, parent);
    }

    public StarToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, end, missing, unexpected, parent);
    }

    public StarToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public StarToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.STAR, TweetQlSyntaxKind.STAR_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
