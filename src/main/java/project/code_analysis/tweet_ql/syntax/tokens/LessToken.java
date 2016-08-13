package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class LessToken extends SyntaxToken {
    public LessToken() {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN);
    }

    public LessToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, missing, unexpected);
    }

    public LessToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, missing, unexpected);
    }

    public LessToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, end, missing, unexpected);
    }

    public LessToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public LessToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public LessToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, missing, unexpected, parent);
    }

    public LessToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, missing, unexpected, parent);
    }

    public LessToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, end, missing, unexpected, parent);
    }

    public LessToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public LessToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxKind.LESS_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
