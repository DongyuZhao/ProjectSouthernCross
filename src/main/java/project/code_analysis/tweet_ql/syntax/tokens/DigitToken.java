package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class DigitToken extends SyntaxToken {
    public DigitToken(String rawString) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN);
    }

    public DigitToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, missing, unexpected);
    }

    public DigitToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, missing, unexpected);
    }

    public DigitToken(String rawString, int start, int end, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, end, missing, unexpected);
    }

    public DigitToken(String rawString, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public DigitToken(String rawString, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public DigitToken(String rawString, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, missing, unexpected, parent);
    }

    public DigitToken(String rawString, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, missing, unexpected, parent);
    }

    public DigitToken(String rawString, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, end, missing, unexpected, parent);
    }

    public DigitToken(String rawString, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public DigitToken(String rawString, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.DIGIT_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
