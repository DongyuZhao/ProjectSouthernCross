package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class BetweenKeywordToken extends TweetQlSyntaxToken {
    public BetweenKeywordToken() {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD);
    }

    public BetweenKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, missing, unexpected);
    }

    public BetweenKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, start, missing, unexpected);
    }

    public BetweenKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, parent, missing, unexpected);
    }

    public BetweenKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, parent, start, missing, unexpected);
    }
}
