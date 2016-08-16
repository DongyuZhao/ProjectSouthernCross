package project.code_analysis.tweet_ql.syntax.tokens;


import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class LiteralStringToken extends SyntaxToken {
    public LiteralStringToken(String rawString) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN);
    }

    public LiteralStringToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, missing, unexpected);
    }

    public LiteralStringToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, missing, unexpected);
    }

    public LiteralStringToken(String rawString, int start, int end, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, end, missing, unexpected);
    }

    public LiteralStringToken(String rawString, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public LiteralStringToken(String rawString, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public LiteralStringToken(String rawString, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, missing, unexpected, parent);
    }

    public LiteralStringToken(String rawString, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, missing, unexpected, parent);
    }

    public LiteralStringToken(String rawString, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, end, missing, unexpected, parent);
    }

    public LiteralStringToken(String rawString, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public LiteralStringToken(String rawString, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.LITERAL_STRING_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
