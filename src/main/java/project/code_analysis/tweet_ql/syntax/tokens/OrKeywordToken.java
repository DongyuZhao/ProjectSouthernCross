package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OrKeywordToken extends TweetQlSyntaxToken {
    public OrKeywordToken() {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD);
    }

    public OrKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, missing, unexpected);
    }

    public OrKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, start, missing, unexpected);
    }

    public OrKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, parent, missing, unexpected);
    }

    public OrKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, parent, start, missing, unexpected);
    }
}
