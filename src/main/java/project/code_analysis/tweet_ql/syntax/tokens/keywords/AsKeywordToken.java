package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * A syntax token class holds "AS"
 */
public class AsKeywordToken extends KeywordToken {
    public AsKeywordToken() {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD);
    }

    public AsKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, error);
    }

    public AsKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, start, error);
    }

    public AsKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, parent, error);
    }

    public AsKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, parent, start, error);
    }
}
