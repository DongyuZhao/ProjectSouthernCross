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
public class LessEqualToken extends TweetQlSyntaxToken {
    public LessEqualToken() {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN);
    }

    public LessEqualToken(SyntaxError error) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN, error);
    }

    public LessEqualToken(int start, SyntaxError error) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN, start, error);
    }

    public LessEqualToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN, parent, error);
    }

    public LessEqualToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.LESS_EQUAL, TweetQlTokenKind.LESS_EQUAL_TOKEN, parent, start, error);
    }
}
