package project.code_analysis.tweet_ql.syntax.tokens;

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

    public AsKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, missing, unexpected);
    }

    public AsKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, start, missing, unexpected);
    }

    public AsKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, parent, missing, unexpected);
    }

    public AsKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlTokenKind.AS_KEYWORD, parent, start, missing, unexpected);
    }
}
