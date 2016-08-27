package project.code_analysis.tweet_ql.syntax.trivias;

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

    public ChangeLineTrivia(boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.CHANGE_LINE, missing, unexpected);
    }

    public ChangeLineTrivia(int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.CHANGE_LINE, start, missing, unexpected);
    }

    public ChangeLineTrivia(SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.CHANGE_LINE, parent, missing, unexpected);
    }

    public ChangeLineTrivia(SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.CHANGE_LINE, parent, start, missing, unexpected);
    }
}
