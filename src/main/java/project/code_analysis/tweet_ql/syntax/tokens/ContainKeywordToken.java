package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class ContainKeywordToken extends TweetQlSyntaxToken {
    public ContainKeywordToken() {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlSyntaxTokenKind.CONTAIN_KEYWORD_TOKEN);
    }

    public ContainKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlSyntaxTokenKind.CONTAIN_KEYWORD_TOKEN, missing, unexpected);
    }

    public ContainKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlSyntaxTokenKind.CONTAIN_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public ContainKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlSyntaxTokenKind.CONTAIN_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public ContainKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlSyntaxTokenKind.CONTAIN_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }
}
