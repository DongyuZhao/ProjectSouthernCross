package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class AscendKeywordToken extends TweetQlSyntaxToken {
    public AscendKeywordToken() {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxTokenKind.ASCEND_KEYWORD_TOKEN);
    }

    public AscendKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxTokenKind.ASCEND_KEYWORD_TOKEN, missing, unexpected);
    }

    public AscendKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxTokenKind.ASCEND_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public AscendKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxTokenKind.ASCEND_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public AscendKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxTokenKind.ASCEND_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
