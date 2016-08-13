package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class CloseBracketToken extends SyntaxToken {
    public CloseBracketToken() {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN);
    }

    public CloseBracketToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, missing, unexpected);
    }

    public CloseBracketToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, missing, unexpected);
    }

    public CloseBracketToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, end, missing, unexpected);
    }

    public CloseBracketToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public CloseBracketToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public CloseBracketToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, missing, unexpected, parent);
    }

    public CloseBracketToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, missing, unexpected, parent);
    }

    public CloseBracketToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, end, missing, unexpected, parent);
    }

    public CloseBracketToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public CloseBracketToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.CLOSE_BRACKET, TweetQlSyntaxKind.CLOSE_BRACKET_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
