package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CreateKeywordToken extends TweetQlSyntaxToken {
    public CreateKeywordToken() {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN);
    }

    public CreateKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN, missing, unexpected);
    }

    public CreateKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public CreateKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN, parent, missing, unexpected);
    }

    public CreateKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CREATE_KEYWORD, TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN, parent, start, missing, unexpected);
    }
}
