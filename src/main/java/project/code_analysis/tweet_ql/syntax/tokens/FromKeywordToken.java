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
public class FromKeywordToken extends TweetQlSyntaxToken {
    public FromKeywordToken() {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD);
    }

    public FromKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, error);
    }

    public FromKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, start, error);
    }

    public FromKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, parent, error);
    }

    public FromKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, parent, start, error);
    }
}
