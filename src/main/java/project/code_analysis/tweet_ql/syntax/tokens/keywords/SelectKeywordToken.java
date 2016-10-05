package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * A syntax token class holds "SELECT"
 */
public class SelectKeywordToken extends KeywordToken {
    public SelectKeywordToken() {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD);
    }

    public SelectKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, error);
    }

    public SelectKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, start, error);
    }

    public SelectKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, parent, error);
    }

    public SelectKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, parent, start, error);
    }
}
