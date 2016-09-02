package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
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

    public DigitToken(String rawString, SyntaxError error) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, error);
    }

    public DigitToken(String rawString, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, start, error);
    }

    public DigitToken(SyntaxNode parent, String rawString, SyntaxError error) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, parent, error);
    }

    public DigitToken(SyntaxNode parent, String rawString, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.DIGIT_TOKEN, parent, start, error);
    }
}
