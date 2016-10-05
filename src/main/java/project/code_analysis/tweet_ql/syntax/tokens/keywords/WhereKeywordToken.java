package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */

/**
 * A syntax token class holds "WHERE"
 */
public class WhereKeywordToken extends KeywordToken {
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
