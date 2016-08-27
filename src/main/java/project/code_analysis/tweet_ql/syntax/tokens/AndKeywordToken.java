package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class AndKeywordToken extends TweetQlSyntaxToken {
    public AndKeywordToken() {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD);
    }

    public AndKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, missing, unexpected);
    }

    public AndKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, start, missing, unexpected);
    }

    public AndKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, parent, missing, unexpected);
    }

    public AndKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, parent, start, missing, unexpected);
    }
}
