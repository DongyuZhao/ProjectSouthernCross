package project.code_analysis.tweet_ql.syntax.tokens;

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

    public SkipKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, missing, unexpected);
    }

    public SkipKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, start, missing, unexpected);
    }

    public SkipKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, parent, missing, unexpected);
    }

    public SkipKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, parent, start, missing, unexpected);
    }
}
