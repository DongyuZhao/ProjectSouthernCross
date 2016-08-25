package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OrKeywordToken extends TweetQlSyntaxToken {
    public OrKeywordToken() {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN);
    }

    public OrKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN, missing, unexpected);
    }

    public OrKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public OrKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public OrKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxTokenKind.OR_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
