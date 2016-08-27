package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class SelectKeywordToken extends TweetQlSyntaxToken {
    public SelectKeywordToken() {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD);
    }

    public SelectKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, missing, unexpected);
    }

    public SelectKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, start, missing, unexpected);
    }

    public SelectKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, parent, missing, unexpected);
    }

    public SelectKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, parent, start, missing, unexpected);
    }
}
