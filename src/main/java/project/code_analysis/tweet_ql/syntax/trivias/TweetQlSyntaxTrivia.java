package project.code_analysis.tweet_ql.syntax.trivias;

import project.code_analysis.core.ISyntaxKind;
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

    public TweetQlSyntaxTrivia(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, missing, unexpected);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, start, missing, unexpected);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, SyntaxNodeOrToken parent, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, parent, missing, unexpected);
    }

    public TweetQlSyntaxTrivia(ISyntaxKind kind, SyntaxNodeOrToken parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, parent, start, missing, unexpected);
    }
}
