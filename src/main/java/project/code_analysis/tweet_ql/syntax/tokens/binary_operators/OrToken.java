package project.code_analysis.tweet_ql.syntax.tokens.binary_operators;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.BinaryOperatorToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */

/**
 * A syntax token class holds "OR"
 */
public class OrToken extends BinaryOperatorToken {
    public OrToken() {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD);
    }

    public OrToken(SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, error);
    }

    public OrToken(int start, SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, start, error);
    }

    public OrToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, parent, error);
    }

    public OrToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlTokenKind.OR_KEYWORD, parent, start, error);
    }
}
