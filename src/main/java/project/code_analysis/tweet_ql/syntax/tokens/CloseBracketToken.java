package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseBracketToken extends TweetQlSyntaxToken {
    public CloseBracketToken() {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET);
    }

    public CloseBracketToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, missing, unexpected);
    }

    public CloseBracketToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, start, missing, unexpected);
    }

    public CloseBracketToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, parent, missing, unexpected);
    }

    public CloseBracketToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, parent, start, missing, unexpected);
    }
}
