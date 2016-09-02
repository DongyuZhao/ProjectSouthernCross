package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
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

    public SelectKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, error);
    }

    public SelectKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, start, error);
    }

    public SelectKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, parent, error);
    }

    public SelectKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.SELECT_KEYWORD, TweetQlTokenKind.SELECT_KEYWORD, parent, start, error);
    }
}
