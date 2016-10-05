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
 * A syntax token class holds "CREATE"
 */
public class CreateKeywordToken extends KeywordToken {
    public CreateKeywordToken() {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlTokenKind.CREATE_KEYWORD);
    }

    public CreateKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlTokenKind.CREATE_KEYWORD, error);
    }

    public CreateKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlTokenKind.CREATE_KEYWORD, start, error);
    }

    public CreateKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlTokenKind.CREATE_KEYWORD, parent, error);
    }

    public CreateKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlTokenKind.CREATE_KEYWORD, parent, start, error);
    }
}
