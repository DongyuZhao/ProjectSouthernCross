package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNodeOrToken;
import project.code_analysis.core.SyntaxTrivia;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
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
