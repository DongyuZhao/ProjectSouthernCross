package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class ContainKeywordToken extends TweetQlSyntaxToken {
    public ContainKeywordToken() {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD);
    }

    public ContainKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, missing, unexpected);
    }

    public ContainKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, start, missing, unexpected);
    }

    public ContainKeywordToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, parent, missing, unexpected);
    }

    public ContainKeywordToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, parent, start, missing, unexpected);
    }
}
