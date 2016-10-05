package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * A syntax trivia class holds block comment
 */
public class BlockCommentsTrivia extends TweetQlSyntaxTrivia {
    public BlockCommentsTrivia() {
        super(TweetQlTriviaKind.BLOCK_COMMENTS);
    }

    public BlockCommentsTrivia(SyntaxError error) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, error);
    }

    public BlockCommentsTrivia(int start, SyntaxError error) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, start, error);
    }

    public BlockCommentsTrivia(SyntaxNodeOrToken parent, SyntaxError error) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, parent, error);
    }

    public BlockCommentsTrivia(SyntaxNodeOrToken parent, int start, SyntaxError error) {
        super(TweetQlTriviaKind.BLOCK_COMMENTS, parent, start, error);
    }
}
