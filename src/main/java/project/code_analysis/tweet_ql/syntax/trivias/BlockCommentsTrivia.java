package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
 */
public class BlockCommentsTrivia extends TweetQlSyntaxTrivia {
    public BlockCommentsTrivia() {
        super(TweetQlTriviaKind.BLOCK_COMMENTS);
    }

    public BlockCommentsTrivia(boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, missing, unexpected);
    }

    public BlockCommentsTrivia(int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, start, missing, unexpected);
    }

    public BlockCommentsTrivia(SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, parent, missing, unexpected);
    }

    public BlockCommentsTrivia(SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, parent, start, missing, unexpected);
    }
}
