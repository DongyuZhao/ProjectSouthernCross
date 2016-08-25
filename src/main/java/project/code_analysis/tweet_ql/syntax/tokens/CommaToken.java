package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CommaToken extends TweetQlSyntaxToken {
    public CommaToken() {
        super(TweetQlTokenString.COMMA, TweetQlSyntaxTokenKind.COMMA_TOKEN);
    }

    public CommaToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COMMA, TweetQlSyntaxTokenKind.COMMA_TOKEN, missing, unexpected);
    }

    public CommaToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.COMMA, TweetQlSyntaxTokenKind.COMMA_TOKEN, start, missing, unexpected);
    }

    public CommaToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.COMMA, TweetQlSyntaxTokenKind.COMMA_TOKEN, missing, unexpected, parent);
    }

    public CommaToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.COMMA, TweetQlSyntaxTokenKind.COMMA_TOKEN, start, missing, unexpected, parent);
    }
}
