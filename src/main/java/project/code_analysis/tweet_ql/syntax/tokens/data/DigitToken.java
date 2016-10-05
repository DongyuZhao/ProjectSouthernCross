package project.code_analysis.tweet_ql.syntax.tokens.data;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.DataToken;

/**
 * A syntax token class holds digitals
 */
public class DigitToken extends DataToken {
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
