package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
 */
public class WhiteSpaceToken extends TweetQlSyntaxToken {
    public WhiteSpaceToken(String rawString) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN);
    }

    public WhiteSpaceToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, missing, unexpected);
    }

    public WhiteSpaceToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, start, missing, unexpected);
    }

    public WhiteSpaceToken(String rawString, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, parent, missing, unexpected);
    }

    public WhiteSpaceToken(String rawString, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, parent, start, missing, unexpected);
    }
}
