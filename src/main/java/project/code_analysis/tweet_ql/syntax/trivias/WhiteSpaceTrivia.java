package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
 */
public class WhiteSpaceTrivia extends TweetQlSyntaxTrivia {
    public WhiteSpaceTrivia() {
        super(TweetQlTriviaKind.WHITE_SPACE);
    }

    public WhiteSpaceTrivia(boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.WHITE_SPACE, missing, unexpected);
    }

    public WhiteSpaceTrivia(int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.WHITE_SPACE, start, missing, unexpected);
    }

    public WhiteSpaceTrivia(SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.WHITE_SPACE, parent, missing, unexpected);
    }

    public WhiteSpaceTrivia(SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.WHITE_SPACE, parent, start, missing, unexpected);
    }
}
