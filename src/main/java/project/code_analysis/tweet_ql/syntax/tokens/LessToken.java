package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class LessToken extends TweetQlSyntaxToken {
    public LessToken() {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN);
    }

    public LessToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, missing, unexpected);
    }

    public LessToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, start, missing, unexpected);
    }

    public LessToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, parent, missing, unexpected);
    }

    public LessToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, parent, start, missing, unexpected);
    }
}
