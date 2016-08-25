package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public class TweetQlSyntaxNode extends SyntaxNode {
    public TweetQlSyntaxNode(ISyntaxKind kind) {
        super(TweetQlTokenString.AND_KEYWORD, kind);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AND_KEYWORD, kind, missing, unexpected);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AND_KEYWORD, kind, start, missing, unexpected);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AND_KEYWORD, kind, missing, unexpected, parent);
    }

    public TweetQlSyntaxNode(ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AND_KEYWORD, kind, start, missing, unexpected, parent);
    }
}
