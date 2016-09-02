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
public class AscendKeywordToken extends TweetQlSyntaxToken {
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
