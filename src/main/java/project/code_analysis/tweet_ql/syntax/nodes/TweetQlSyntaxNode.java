package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

/**
 * A common parent of all of the TweetQL syntax node
 */
public class TweetQlSyntaxNode extends SyntaxNode {
    public TweetQlSyntaxNode(ISyntaxKind kind) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, error);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, int start, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, start, error);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, parent, error);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlSyntaxFacts.getInstance().getLanguage(), kind, parent, start, error);
    }
}
