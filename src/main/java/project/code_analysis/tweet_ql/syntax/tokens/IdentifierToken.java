package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxError;
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

    public IdentifierToken(String rawString, SyntaxError error) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, error);
    }

    public IdentifierToken(String rawString, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, start, error);
    }

    public IdentifierToken(String rawString, SyntaxNode parent, SyntaxError error) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, parent, error);
    }

    public IdentifierToken(String rawString, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, TweetQlTokenKind.IDENTIFIER_TOKEN, parent, start, error);
    }
}
