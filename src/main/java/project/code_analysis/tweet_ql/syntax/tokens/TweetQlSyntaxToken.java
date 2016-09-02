package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public class TweetQlSyntaxToken extends SyntaxToken {
    public TweetQlSyntaxToken(String rawString, ISyntaxKind kind) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), rawString, kind);
    }

    public TweetQlSyntaxToken(String rawString, ISyntaxKind kind, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), rawString, kind, error);
    }

    public TweetQlSyntaxToken(String rawString, ISyntaxKind kind, int start, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), rawString, kind, start, error);
    }

    public TweetQlSyntaxToken(String rawString, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), rawString, kind, parent, error);
    }

    public TweetQlSyntaxToken(String rawString, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), rawString, kind, parent, start, error);
    }
}
