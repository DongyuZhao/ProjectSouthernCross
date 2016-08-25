package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class DotToken extends TweetQlSyntaxToken {
    public DotToken() {
        super(TweetQlTokenString.DOT, TweetQlSyntaxTokenKind.DOT_TOKEN);
    }

    public DotToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.DOT, TweetQlSyntaxTokenKind.DOT_TOKEN, missing, unexpected);
    }

    public DotToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.DOT, TweetQlSyntaxTokenKind.DOT_TOKEN, start, missing, unexpected);
    }

    public DotToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.DOT, TweetQlSyntaxTokenKind.DOT_TOKEN, missing, unexpected, parent);
    }

    public DotToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.DOT, TweetQlSyntaxTokenKind.DOT_TOKEN, start, missing, unexpected, parent);
    }
}
