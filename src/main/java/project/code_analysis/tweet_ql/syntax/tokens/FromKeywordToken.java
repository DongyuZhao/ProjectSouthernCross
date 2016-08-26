package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class FromKeywordToken extends TweetQlSyntaxToken {
    public FromKeywordToken() {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN);
    }

    public FromKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN, missing, unexpected);
    }

    public FromKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public FromKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public FromKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
