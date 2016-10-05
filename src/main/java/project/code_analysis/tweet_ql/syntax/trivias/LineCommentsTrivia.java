package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.tweet_ql.TweetQlTriviaKind;

/**
 * A syntax trivia class holds line comments
 */
public class LineCommentsTrivia extends TweetQlSyntaxTrivia {
    public LineCommentsTrivia() {
        super(TweetQlTriviaKind.LINE_COMMENTS);
    }

    public LineCommentsTrivia(SyntaxError error) {
        super(TweetQlTriviaKind.LINE_COMMENTS, error);
    }

    public LineCommentsTrivia(int start, SyntaxError error) {
        super(TweetQlTriviaKind.LINE_COMMENTS, start, error);
    }

    public LineCommentsTrivia(SyntaxNodeOrToken parent, SyntaxError error) {
        super(TweetQlTriviaKind.LINE_COMMENTS, parent, error);
    }

    public LineCommentsTrivia(SyntaxNodeOrToken parent, int start, SyntaxError error) {
        super(TweetQlTriviaKind.LINE_COMMENTS, parent, start, error);
    }
}
