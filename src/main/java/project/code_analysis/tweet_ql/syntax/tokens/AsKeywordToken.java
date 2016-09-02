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
public class AsKeywordToken extends TweetQlSyntaxToken {
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
