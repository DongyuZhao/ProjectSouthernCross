package project.code_analysis.tweet_ql.syntax.tokens.symbols;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.SymbolToken;

/**
 * A syntax token class holds "["
 */
public class OpenBracketToken extends SymbolToken {
    public OpenBracketToken() {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET);
    }

    public OpenBracketToken(SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, error);
    }

    public OpenBracketToken(int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, start, error);
    }

    public OpenBracketToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, parent, error);
    }

    public OpenBracketToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.OPEN_BRACKET, TweetQlTokenKind.OPEN_BRACKET, parent, start, error);
    }
}
