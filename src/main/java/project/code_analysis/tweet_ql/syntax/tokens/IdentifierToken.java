package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class IdentifierToken extends SyntaxToken {
    public IdentifierToken(String rawString) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN);
    }

    public IdentifierToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, missing, unexpected);
    }

    public IdentifierToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, missing, unexpected);
    }

    public IdentifierToken(String rawString, int start, int end, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, end, missing, unexpected);
    }

    public IdentifierToken(String rawString, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public IdentifierToken(String rawString, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public IdentifierToken(String rawString, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, missing, unexpected, parent);
    }

    public IdentifierToken(String rawString, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, missing, unexpected, parent);
    }

    public IdentifierToken(String rawString, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, end, missing, unexpected, parent);
    }

    public IdentifierToken(String rawString, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public IdentifierToken(String rawString, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxKind.IDENTIFIER_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
