package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class FromKeywordToken extends TweetQlSyntaxToken {
    public FromKeywordToken() {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD);
    }

    public FromKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, missing, unexpected);
    }

    public FromKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, start, missing, unexpected);
    }

    public FromKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, parent, missing, unexpected);
    }

    public FromKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.FROM_KEYWORD, TweetQlTokenKind.FROM_KEYWORD, parent, start, missing, unexpected);
    }
}
