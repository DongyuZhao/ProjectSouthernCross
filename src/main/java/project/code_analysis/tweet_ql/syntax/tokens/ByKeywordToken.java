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
public class ByKeywordToken extends TweetQlSyntaxToken {
    public ByKeywordToken() {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlTokenKind.BY_KEYWORD);
    }

    public ByKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlTokenKind.BY_KEYWORD, error);
    }

    public ByKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlTokenKind.BY_KEYWORD, start, error);
    }

    public ByKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlTokenKind.BY_KEYWORD, parent, error);
    }

    public ByKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.BY_KEYWORD, TweetQlTokenKind.BY_KEYWORD, parent, start, error);
    }
}
