package project.code_analysis.tweet_ql.syntax.tokens.symbols;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.SymbolToken;

/**
 * A syntax token class holds "{"
 */
public class OpenBraceToken extends SymbolToken {
    public OpenBraceToken() {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE);
    }

    public OpenBraceToken(SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, error);
    }

    public OpenBraceToken(int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, start, error);
    }

    public OpenBraceToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, parent, error);
    }

    public OpenBraceToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACE, TweetQlTokenKind.OPEN_BRACE, parent, start, error);
    }
}
