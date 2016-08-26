package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class DescendKeywordToken extends TweetQlSyntaxToken {
    public DescendKeywordToken() {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlSyntaxTokenKind.DESCEND_KEYWORD_TOKEN);
    }

    public DescendKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlSyntaxTokenKind.DESCEND_KEYWORD_TOKEN, missing, unexpected);
    }

    public DescendKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlSyntaxTokenKind.DESCEND_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public DescendKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlSyntaxTokenKind.DESCEND_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public DescendKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlSyntaxTokenKind.DESCEND_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
