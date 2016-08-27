package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class NotKeywordToken extends TweetQlSyntaxToken {
    public NotKeywordToken() {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD);
    }

    public NotKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, missing, unexpected);
    }

    public NotKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, start, missing, unexpected);
    }

    public NotKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, parent, missing, unexpected);
    }

    public NotKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlTokenKind.NOT_KEYWORD, parent, start, missing, unexpected);
    }
}
