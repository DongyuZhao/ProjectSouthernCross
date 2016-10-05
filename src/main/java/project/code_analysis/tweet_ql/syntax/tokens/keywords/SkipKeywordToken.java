package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * A syntax token class holds "SKIP"
 */
public class SkipKeywordToken extends KeywordToken {
    public SkipKeywordToken() {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD);
    }

    public SkipKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, error);
    }

    public SkipKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, start, error);
    }

    public SkipKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, parent, error);
    }

    public SkipKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.SKIP_KEYWORD, TweetQlTokenKind.SKIP_KEYWORD, parent, start, error);
    }
}
