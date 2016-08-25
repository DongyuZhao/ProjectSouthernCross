package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class NotKeywordToken extends TweetQlSyntaxToken {
    public NotKeywordToken() {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN);
    }

    public NotKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN, missing, unexpected);
    }

    public NotKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public NotKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public NotKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.NOT_KEYWORD, TweetQlSyntaxTokenKind.NOT_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
