package project.code_analysis.tweet_ql.syntax.tokens.symbols;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.SymbolToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */

/**
 * A syntax token class holds "}"
 */
public class CloseBraceToken extends SymbolToken {
    public CloseBraceToken() {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE);
    }

    public CloseBraceToken(SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, error);
    }

    public CloseBraceToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, start, error);
    }

    public CloseBraceToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, parent, error);
    }

    public CloseBraceToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CLOSE_BRACE, TweetQlTokenKind.CLOSE_BRACE, parent, start, error);
    }
}
