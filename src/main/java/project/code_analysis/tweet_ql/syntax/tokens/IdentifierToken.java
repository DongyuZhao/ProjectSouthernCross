package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class IdentifierToken extends TweetQlSyntaxToken {
    public IdentifierToken(String rawString) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN);
    }

    public IdentifierToken(String rawString, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, missing, unexpected);
    }

    public IdentifierToken(String rawString, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, start, missing, unexpected);
    }

    public IdentifierToken(String rawString, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, parent, missing, unexpected);
    }

    public IdentifierToken(String rawString, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, parent, start, missing, unexpected);
    }
}
