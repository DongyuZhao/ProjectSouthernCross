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
public class SkipKeywordToken extends TweetQlSyntaxToken {
    public SkipKeywordToken() {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD);
    }

    public SkipKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, error);
    }

    public SkipKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, start, error);
    }

    public SkipKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, parent, error);
    }

    public SkipKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, parent, start, error);
    }
}
