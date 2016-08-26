package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class SkipKeywordToken extends TweetQlSyntaxToken {
    public SkipKeywordToken() {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlSyntaxTokenKind.SKIP_KEYWORD_TOKEN);
    }

    public SkipKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlSyntaxTokenKind.SKIP_KEYWORD_TOKEN, missing, unexpected);
    }

    public SkipKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlSyntaxTokenKind.SKIP_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public SkipKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlSyntaxTokenKind.SKIP_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public SkipKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlSyntaxTokenKind.SKIP_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
