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
public class DotToken extends TweetQlSyntaxToken {
    public DotToken() {
        super(TweetQlTokenString.DOT, TweetQlTokenKind.DOT_TOKEN);
    }

    public DotToken(SyntaxError error) {
        super(TweetQlTokenString.DOT, TweetQlTokenKind.DOT_TOKEN, error);
    }

    public DotToken(int start, SyntaxError error) {
        super(TweetQlTokenString.DOT, TweetQlTokenKind.DOT_TOKEN, start, error);
    }

    public DotToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.DOT, TweetQlTokenKind.DOT_TOKEN, parent, error);
    }

    public DotToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.DOT, TweetQlTokenKind.DOT_TOKEN, parent, start, error);
    }
}
