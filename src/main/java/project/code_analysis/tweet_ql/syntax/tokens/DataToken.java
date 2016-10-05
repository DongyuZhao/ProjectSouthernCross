package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;

/**
 * A common parent of all of data tokens in TweetQL
 */
public class DataToken extends TweetQlSyntaxToken {
    public DataToken(String rawString, ISyntaxKind kind) {
        super(rawString, kind);
    }

    public DataToken(String rawString, ISyntaxKind kind, SyntaxError error) {
        super(rawString, kind, error);
    }

    public DataToken(String rawString, ISyntaxKind kind, int start, SyntaxError error) {
        super(rawString, kind, start, error);
    }

    public DataToken(String rawString, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(rawString, kind, parent, error);
    }

    public DataToken(String rawString, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, kind, parent, start, error);
    }
}
