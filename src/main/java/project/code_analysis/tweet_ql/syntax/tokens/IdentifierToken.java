package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class IdentifierToken extends TweetQlSyntaxToken {
    public IdentifierToken(String rawString) {
        super(rawString, TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN);
    }

    public IdentifierToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN, missing, unexpected);
    }

    public IdentifierToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN, start, missing, unexpected);
    }

    public IdentifierToken(String rawString, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN, missing, unexpected, parent);
    }

    public IdentifierToken(String rawString, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(rawString, TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN, start, missing, unexpected, parent);
    }
}
