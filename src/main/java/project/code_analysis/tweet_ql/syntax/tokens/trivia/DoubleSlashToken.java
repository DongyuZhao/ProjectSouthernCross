package project.code_analysis.tweet_ql.syntax.tokens.trivia;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.TriviaToken;

/**
 * A syntax token class holds "//"
 */
public class DoubleSlashToken extends TriviaToken {
    public DoubleSlashToken() {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN);
    }

    public DoubleSlashToken(SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, error);
    }

    public DoubleSlashToken(int start, SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, start, error);
    }

    public DoubleSlashToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, parent, error);
    }

    public DoubleSlashToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.DOUBLE_SLASH, TweetQlTokenKind.DOUBLE_SLASH_TOKEN, parent, start, error);
    }
}
