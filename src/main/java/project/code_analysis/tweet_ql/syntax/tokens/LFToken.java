package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class LFToken extends TweetQlSyntaxToken {
    public LFToken() {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN);
    }

    public LFToken(SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, error);
    }

    public LFToken(int start, SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, start, error);
    }

    public LFToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, parent, error);
    }

    public LFToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, parent, start, error);
    }
}
