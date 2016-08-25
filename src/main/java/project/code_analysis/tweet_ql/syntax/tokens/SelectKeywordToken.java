package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class SelectKeywordToken extends TweetQlSyntaxToken {
    public SelectKeywordToken() {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN);
    }

    public SelectKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, missing, unexpected);
    }

    public SelectKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public SelectKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public SelectKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
