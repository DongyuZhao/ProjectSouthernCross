package project.code_analysis.tweet_ql.syntax.tokens.symbols;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.SymbolToken;

/**
 * A syntax token class holds ","
 */
public class CommaToken extends SymbolToken {
    public CommaToken() {
        super(TweetQlTokenString.COMMA, TweetQlTokenKind.COMMA_TOKEN);
    }

    public CommaToken(SyntaxError error) {
        super(TweetQlTokenString.COMMA, TweetQlTokenKind.COMMA_TOKEN, error);
    }

    public CommaToken(int start, SyntaxError error) {
        super(TweetQlTokenString.COMMA, TweetQlTokenKind.COMMA_TOKEN, start, error);
    }

    public CommaToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.COMMA, TweetQlTokenKind.COMMA_TOKEN, parent, error);
    }

    public CommaToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.COMMA, TweetQlTokenKind.COMMA_TOKEN, parent, start, error);
    }
}
