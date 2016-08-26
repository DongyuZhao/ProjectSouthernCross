package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class WindowKeywordToken extends TweetQlSyntaxToken {
    public WindowKeywordToken() {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlSyntaxTokenKind.WINDOW_KEYWORD_TOKEN);
    }

    public WindowKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlSyntaxTokenKind.WINDOW_KEYWORD_TOKEN, missing, unexpected);
    }

    public WindowKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlSyntaxTokenKind.WINDOW_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public WindowKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlSyntaxTokenKind.WINDOW_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public WindowKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlSyntaxTokenKind.WINDOW_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
