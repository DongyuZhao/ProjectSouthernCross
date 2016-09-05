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
public class OrKeywordToken extends BinaryOperatorToken {
    public OrKeywordToken() {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD);
    }

    public OrKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, error);
    }

    public OrKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, start, error);
    }

    public OrKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, parent, error);
    }

    public OrKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, parent, start, error);
    }
}
