package project.code_analysis.tweet_ql.syntax.tokens;


import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/16.
 */
public class LiteralStringToken extends TweetQlSyntaxToken {
    public LiteralStringToken(String rawString) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN);
    }

    public LiteralStringToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, missing, unexpected);
    }

    public LiteralStringToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, start, missing, unexpected);
    }

    public LiteralStringToken(String rawString, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, parent, missing, unexpected);
    }

    public LiteralStringToken(String rawString, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, parent, start, missing, unexpected);
    }
}
