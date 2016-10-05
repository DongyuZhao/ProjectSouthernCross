package project.code_analysis.tweet_ql.syntax.tokens.data;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.DataToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */

/**
 * A syntax token class holds identifier
 */
public class IdentifierToken extends DataToken {
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

    public static boolean isIdentifier(SyntaxToken token) {
        return token != null && (token.getKind() == TweetQlTokenKind.IDENTIFIER_TOKEN || token.getKind() == TweetQlTokenKind.STAR_TOKEN);
    }
}
