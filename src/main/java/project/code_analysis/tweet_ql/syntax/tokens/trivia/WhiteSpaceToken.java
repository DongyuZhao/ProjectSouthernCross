package project.code_analysis.tweet_ql.syntax.tokens.trivia;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.TriviaToken;

/**
 * A syntax token class holds white spaces
 */
public class WhiteSpaceToken extends TriviaToken {
    public WhiteSpaceToken(String rawString) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN);
    }

    public WhiteSpaceToken(String rawString, SyntaxError error) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, error);
    }

    public WhiteSpaceToken(String rawString, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, start, error);
    }

    public WhiteSpaceToken(String rawString, SyntaxNode parent, SyntaxError error) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, parent, error);
    }

    public WhiteSpaceToken(String rawString, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.WHITE_SPACE_TOKEN, parent, start, error);
    }
}
