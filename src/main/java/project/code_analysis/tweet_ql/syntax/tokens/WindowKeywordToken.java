package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class WindowKeywordToken extends TweetQlSyntaxToken {
    public WindowKeywordToken() {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD);
    }

    public WindowKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, missing, unexpected);
    }

    public WindowKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, start, missing, unexpected);
    }

    public WindowKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, parent, missing, unexpected);
    }

    public WindowKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, parent, start, missing, unexpected);
    }
}
