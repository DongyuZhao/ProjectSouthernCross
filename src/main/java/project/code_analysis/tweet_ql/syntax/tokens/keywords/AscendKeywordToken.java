package project.code_analysis.tweet_ql.syntax.tokens.keywords;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.KeywordToken;

/**
 * A syntax token class holds "ASCEND"
 */
public class AscendKeywordToken extends KeywordToken {
    public AscendKeywordToken() {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD);
    }

    public AscendKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, error);
    }

    public AscendKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, start, error);
    }

    public AscendKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, parent, error);
    }

    public AscendKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, parent, start, error);
    }
}
