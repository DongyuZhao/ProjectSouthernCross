package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseBracketToken extends TweetQlSyntaxToken {
    public CloseBracketToken() {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxTokenKind.CLOSE_BRACKET_TOKEN);
    }

    public CloseBracketToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxTokenKind.CLOSE_BRACKET_TOKEN, missing, unexpected);
    }

    public CloseBracketToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxTokenKind.CLOSE_BRACKET_TOKEN, start, missing, unexpected);
    }

    public CloseBracketToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxTokenKind.CLOSE_BRACKET_TOKEN, parent, missing, unexpected);
    }

    public CloseBracketToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxTokenKind.CLOSE_BRACKET_TOKEN, parent, start, missing, unexpected);
    }
}
