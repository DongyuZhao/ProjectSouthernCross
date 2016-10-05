package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.core.SyntaxTrivia;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

/**
 * A common parent of all of the TweetQL syntax trivia
 */
public class TweetQlSyntaxTrivia extends SyntaxTrivia {
    public TweetQlSyntaxTrivia(ISyntaxKind kind) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, error);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, int start, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, start, error);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, SyntaxNodeOrToken parent, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, parent, error);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, SyntaxNodeOrToken parent, int start, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, parent, start, error);
    }
}
