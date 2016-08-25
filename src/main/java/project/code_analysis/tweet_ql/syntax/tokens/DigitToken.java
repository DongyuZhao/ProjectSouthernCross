package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class DigitToken extends TweetQlSyntaxToken {
    public DigitToken(String rawString) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN);
    }

    public DigitToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, missing, unexpected);
    }

    public DigitToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, missing, unexpected);
    }

    public DigitToken(String rawString, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, missing, unexpected, parent);
    }

    public DigitToken(String rawString, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, missing, unexpected, parent);
    }
}
