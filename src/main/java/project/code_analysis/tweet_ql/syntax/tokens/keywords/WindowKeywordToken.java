package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */

/**
 * A syntax token class holds "WINDOW"
 */
public class WindowKeywordToken extends KeywordToken {
    public WindowKeywordToken() {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD);
    }

    public WindowKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, error);
    }

    public WindowKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, start, error);
    }

    public WindowKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, parent, error);
    }

    public WindowKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.WINDOW_KEYWORD, TweetQlTokenKind.WINDOW_KEYWORD, parent, start, error);
    }
}
