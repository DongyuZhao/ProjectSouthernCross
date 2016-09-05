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
public class ContainKeywordToken extends BinaryOperatorToken {
    public ContainKeywordToken() {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD);
    }

    public ContainKeywordToken(SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, error);
    }

    public ContainKeywordToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, start, error);
    }

    public ContainKeywordToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, parent, error);
    }

    public ContainKeywordToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CONTAIN_KEYWORD, TweetQlTokenKind.CONTAIN_KEYWORD, parent, start, error);
    }
}
