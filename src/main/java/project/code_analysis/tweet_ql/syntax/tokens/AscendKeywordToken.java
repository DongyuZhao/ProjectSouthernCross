package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class AscendKeywordToken extends TweetQlSyntaxToken {
    public AscendKeywordToken() {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD);
    }

    public AscendKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, missing, unexpected);
    }

    public AscendKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, start, missing, unexpected);
    }

    public AscendKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, parent, missing, unexpected);
    }

    public AscendKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlTokenKind.ASCEND_KEYWORD, parent, start, missing, unexpected);
    }
}
