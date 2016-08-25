package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class ColonToken extends TweetQlSyntaxToken {
    public ColonToken() {
        super(TweetQlTokenString.COLON, TweetQlSyntaxTokenKind.COLON_TOKEN);
    }

    public ColonToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COLON, TweetQlSyntaxTokenKind.COLON_TOKEN, missing, unexpected);
    }

    public ColonToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COLON, TweetQlSyntaxTokenKind.COLON_TOKEN, start, missing, unexpected);
    }

    public ColonToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.COLON, TweetQlSyntaxTokenKind.COLON_TOKEN, missing, unexpected, parent);
    }

    public ColonToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.COLON, TweetQlSyntaxTokenKind.COLON_TOKEN, start, missing, unexpected, parent);
    }
}
