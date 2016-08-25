package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class WhereKeywordToken extends TweetQlSyntaxToken {
    public WhereKeywordToken() {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxTokenKind.WHERE_KEYWORD_TOKEN);
    }

    public WhereKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxTokenKind.WHERE_KEYWORD_TOKEN, missing, unexpected);
    }

    public WhereKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxTokenKind.WHERE_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public WhereKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxTokenKind.WHERE_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public WhereKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxTokenKind.WHERE_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
