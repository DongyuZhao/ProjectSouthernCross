package project.code_analysis.tweet_ql.syntax.tokens.data;


import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.DataToken;

/**
 * A syntax token class holds literal string
 */
public class LiteralStringToken extends DataToken {
    public LiteralStringToken(String rawString) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN);
    }

    public LiteralStringToken(String rawString, SyntaxError error) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, error);
    }

    public LiteralStringToken(String rawString, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, start, error);
    }

    public LiteralStringToken(String rawString, SyntaxNode parent, SyntaxError error) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, parent, error);
    }

    public LiteralStringToken(String rawString, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.LITERAL_STRING_TOKEN, parent, start, error);
    }
}
