package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
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
