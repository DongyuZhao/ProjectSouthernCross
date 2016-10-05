package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * A syntax token class holds "FROM"
 */
public class FromKeywordToken extends KeywordToken {
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
