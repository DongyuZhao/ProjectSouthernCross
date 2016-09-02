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
public class OpenBracketToken extends TweetQlSyntaxToken {
    public OpenBracketToken() {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET);
    }

    public OpenBracketToken(SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, error);
    }

    public OpenBracketToken(int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, start, error);
    }

    public OpenBracketToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, parent, error);
    }

    public OpenBracketToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, parent, start, error);
    }
}
