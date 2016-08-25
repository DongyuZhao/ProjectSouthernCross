package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class LessToken extends TweetQlSyntaxToken {
    public LessToken() {
        super(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN);
    }

    public LessToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN, missing, unexpected);
    }

    public LessToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN, start, missing, unexpected);
    }

    public LessToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN, missing, unexpected, parent);
    }

    public LessToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.LESS, TweetQlSyntaxTokenKind.LESS_TOKEN, start, missing, unexpected, parent);
    }
}
