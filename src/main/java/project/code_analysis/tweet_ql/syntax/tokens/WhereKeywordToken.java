package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class WhereKeywordToken extends TweetQlSyntaxToken {
    public WhereKeywordToken() {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD);
    }

    public WhereKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, missing, unexpected);
    }

    public WhereKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, start, missing, unexpected);
    }

    public WhereKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, parent, missing, unexpected);
    }

    public WhereKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, parent, start, missing, unexpected);
    }
}
