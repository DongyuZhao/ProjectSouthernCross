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
public class WhereKeywordToken extends TweetQlSyntaxToken {
    public WhereKeywordToken() {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD);
    }

    public WhereKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, error);
    }

    public WhereKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, start, error);
    }

    public WhereKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, parent, error);
    }

    public WhereKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlTokenKind.WHERE_KEYWORD, parent, start, error);
    }
}
