package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class AscendKeywordToken extends SyntaxToken {
    public AscendKeywordToken() {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN);
    }

    public AscendKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, missing, unexpected);
    }

    public AscendKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public AscendKeywordToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, end, missing, unexpected);
    }

    public AscendKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public AscendKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public AscendKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public AscendKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }

    public AscendKeywordToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, end, missing, unexpected, parent);
    }

    public AscendKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public AscendKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.ASCEND_KEYWORD, TweetQlSyntaxKind.ASCEND_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}