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
public class LessEqualToken extends SyntaxToken {
    public LessEqualToken() {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN);
    }

    public LessEqualToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, missing, unexpected);
    }

    public LessEqualToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, missing, unexpected);
    }

    public LessEqualToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, end, missing, unexpected);
    }

    public LessEqualToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public LessEqualToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public LessEqualToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, missing, unexpected, parent);
    }

    public LessEqualToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, missing, unexpected, parent);
    }

    public LessEqualToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, end, missing, unexpected, parent);
    }

    public LessEqualToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public LessEqualToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlSyntaxKind.LESS_EQUAL_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
