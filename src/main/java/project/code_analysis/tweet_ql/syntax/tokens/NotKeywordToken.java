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
public class NotKeywordToken extends UnaryOperatorToken {
    public NotKeywordToken() {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD);
    }

    public NotKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, error);
    }

    public NotKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, start, error);
    }

    public NotKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, parent, error);
    }

    public NotKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, parent, start, error);
    }
}
