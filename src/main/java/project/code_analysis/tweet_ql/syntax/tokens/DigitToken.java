package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class DigitToken extends TweetQlSyntaxToken {
    public DigitToken(String rawString) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN);
    }

    public DigitToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, missing, unexpected);
    }

    public DigitToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, start, missing, unexpected);
    }

    public DigitToken(SyntaxNode parent, String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, parent, missing, unexpected);
    }

    public DigitToken(SyntaxNode parent, String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, parent, start, missing, unexpected);
    }
}
