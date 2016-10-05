package project.code_analysis.tweet_ql.syntax.tokens.trivia;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.TriviaToken;

/**
 * A syntax token class holds "\n"
 */
public class LFToken extends TriviaToken {
    public LFToken() {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN);
    }

    public LFToken(SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, error);
    }

    public LFToken(int start, SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, start, error);
    }

    public LFToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, parent, error);
    }

    public LFToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.LF, TweetQlTokenKind.LF_TOKEN, parent, start, error);
    }
}
