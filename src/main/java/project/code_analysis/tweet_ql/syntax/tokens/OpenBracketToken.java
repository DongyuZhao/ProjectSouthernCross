package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OpenBracketToken extends TweetQlSyntaxToken {
    public OpenBracketToken() {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET);
    }

    public OpenBracketToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, missing, unexpected);
    }

    public OpenBracketToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, start, missing, unexpected);
    }

    public OpenBracketToken(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, parent, missing, unexpected);
    }

    public OpenBracketToken(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, parent, start, missing, unexpected);
    }
}
