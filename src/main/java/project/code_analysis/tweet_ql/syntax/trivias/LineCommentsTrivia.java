package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
 */
public class LineCommentsTrivia extends TweetQlSyntaxTrivia {
    public LineCommentsTrivia() {
        super(TweetQlTriviaKind.LINE_COMMENTS);
    }

    public LineCommentsTrivia(boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.LINE_COMMENTS, missing, unexpected);
    }

    public LineCommentsTrivia(int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.LINE_COMMENTS, start, missing, unexpected);
    }

    public LineCommentsTrivia(SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.LINE_COMMENTS, parent, missing, unexpected);
    }

    public LineCommentsTrivia(SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.LINE_COMMENTS, parent, start, missing, unexpected);
    }
}
