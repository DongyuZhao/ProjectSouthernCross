package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
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

    public LessToken(SyntaxError error) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, error);
    }

    public LessToken(int start, SyntaxError error) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, start, error);
    }

    public LessToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, parent, error);
    }

    public LessToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.LESS, TweetQlTokenKind.LESS_TOKEN, parent, start, error);
    }
}
