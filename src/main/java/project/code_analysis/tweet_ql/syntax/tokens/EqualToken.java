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
public class EqualToken extends SyntaxToken {
    public EqualToken() {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN);
    }

    public EqualToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, missing, unexpected);
    }

    public EqualToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, missing, unexpected);
    }

    public EqualToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, end, missing, unexpected);
    }

    public EqualToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public EqualToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public EqualToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, missing, unexpected, parent);
    }

    public EqualToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, missing, unexpected, parent);
    }

    public EqualToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, end, missing, unexpected, parent);
    }

    public EqualToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public EqualToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.EQUAL, TweetQlSyntaxKind.EQUAL_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
