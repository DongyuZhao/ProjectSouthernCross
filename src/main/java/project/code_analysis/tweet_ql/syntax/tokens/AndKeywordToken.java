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
public class AndKeywordToken extends TweetQlSyntaxToken {
    public AndKeywordToken() {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD);
    }

    public AndKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, error);
    }

    public AndKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, start, error);
    }

    public AndKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, parent, error);
    }

    public AndKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.AND_KEYWORD, TweetQlTokenKind.AND_KEYWORD, parent, start, error);
    }
}
