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
public class BetweenKeywordToken extends TweetQlSyntaxToken {
    public BetweenKeywordToken() {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD);
    }

    public BetweenKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, error);
    }

    public BetweenKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, start, error);
    }

    public BetweenKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, parent, error);
    }

    public BetweenKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.BETWEEN_KEYWORD, TweetQlTokenKind.BETWEEN_KEYWORD, parent, start, error);
    }
}
