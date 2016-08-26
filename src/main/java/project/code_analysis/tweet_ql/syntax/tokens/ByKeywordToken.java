package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class ByKeywordToken extends TweetQlSyntaxToken {
    public ByKeywordToken() {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlSyntaxTokenKind.BY_KEYWORD_TOKEN);
    }

    public ByKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlSyntaxTokenKind.BY_KEYWORD_TOKEN, missing, unexpected);
    }

    public ByKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlSyntaxTokenKind.BY_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public ByKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlSyntaxTokenKind.BY_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public ByKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlSyntaxTokenKind.BY_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
