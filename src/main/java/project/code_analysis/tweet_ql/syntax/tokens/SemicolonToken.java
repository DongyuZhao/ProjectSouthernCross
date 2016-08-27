package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class SemicolonToken extends TweetQlSyntaxToken {
    public SemicolonToken() {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN);
    }

    public SemicolonToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, missing, unexpected);
    }

    public SemicolonToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, start, missing, unexpected);
    }

    public SemicolonToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, parent, missing, unexpected);
    }

    public SemicolonToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, parent, start, missing, unexpected);
    }
}
