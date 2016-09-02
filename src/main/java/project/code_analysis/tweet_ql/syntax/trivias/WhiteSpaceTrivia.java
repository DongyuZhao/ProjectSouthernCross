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
public class WhiteSpaceTrivia extends TweetQlSyntaxTrivia {
    public WhiteSpaceTrivia() {
        super(TweetQlTriviaKind.WHITE_SPACE);
    }

    public WhiteSpaceTrivia(SyntaxError error) {
        super(TweetQlTriviaKind.WHITE_SPACE, error);
    }

    public WhiteSpaceTrivia(int start, SyntaxError error) {
        super(TweetQlTriviaKind.WHITE_SPACE, start, error);
    }

    public WhiteSpaceTrivia(SyntaxNodeOrToken parent, SyntaxError error) {
        super(TweetQlTriviaKind.WHITE_SPACE, parent, error);
    }

    public WhiteSpaceTrivia(SyntaxNodeOrToken parent, int start, SyntaxError error) {
        super(TweetQlTriviaKind.WHITE_SPACE, parent, start, error);
    }
}
