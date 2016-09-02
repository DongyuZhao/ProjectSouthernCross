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
public class DescendKeywordToken extends TweetQlSyntaxToken {
    public DescendKeywordToken() {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlTokenKind.DESCEND_KEYWORD);
    }

    public DescendKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlTokenKind.DESCEND_KEYWORD, error);
    }

    public DescendKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlTokenKind.DESCEND_KEYWORD, start, error);
    }

    public DescendKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlTokenKind.DESCEND_KEYWORD, parent, error);
    }

    public DescendKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.DESCEND_KEYWORD, TweetQlTokenKind.DESCEND_KEYWORD, parent, start, error);
    }
}
