package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * A syntax trivia class holds change line symbol
 */
public class ChangeLineTrivia extends TweetQlSyntaxTrivia {
    public ChangeLineTrivia() {
        super(TweetQlTriviaKind.CHANGE_LINE);
    }

    public ChangeLineTrivia(SyntaxError error) {
        super(TweetQlTriviaKind.CHANGE_LINE, error);
    }

    public ChangeLineTrivia(int start, SyntaxError error) {
        super(TweetQlTriviaKind.CHANGE_LINE, start, error);
    }

    public ChangeLineTrivia(SyntaxNodeOrToken parent, SyntaxError error) {
        super(TweetQlTriviaKind.CHANGE_LINE, parent, error);
    }

    public ChangeLineTrivia(SyntaxNodeOrToken parent, int start, SyntaxError error) {
        super(TweetQlTriviaKind.CHANGE_LINE, parent, start, error);
    }
}
