package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * A syntax token class holds "BY"
 */
public class ByKeywordToken extends KeywordToken {
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
