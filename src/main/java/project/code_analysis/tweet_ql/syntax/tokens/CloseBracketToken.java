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
public class CloseBracketToken extends TweetQlSyntaxToken {
    public CloseBracketToken() {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET);
    }

    public CloseBracketToken(SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, error);
    }

    public CloseBracketToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, start, error);
    }

    public CloseBracketToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, parent, error);
    }

    public CloseBracketToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlTokenKind.CLOSE_BRACKET, parent, start, error);
    }
}
