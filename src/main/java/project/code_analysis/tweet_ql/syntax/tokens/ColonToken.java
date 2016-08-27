package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class ColonToken extends TweetQlSyntaxToken {
    public ColonToken() {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN);
    }

    public ColonToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, missing, unexpected);
    }

    public ColonToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, start, missing, unexpected);
    }

    public ColonToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, parent, missing, unexpected);
    }

    public ColonToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, parent, start, missing, unexpected);
    }
}
