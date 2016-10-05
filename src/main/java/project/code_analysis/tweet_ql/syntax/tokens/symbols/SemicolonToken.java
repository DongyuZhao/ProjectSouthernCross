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
 * A syntax token class holds ";"
 */
public class SemicolonToken extends SymbolToken {
    public SemicolonToken() {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN);
    }

    public SemicolonToken(SyntaxError error) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, error);
    }

    public SemicolonToken(int start, SyntaxError error) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, start, error);
    }

    public SemicolonToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, parent, error);
    }

    public SemicolonToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.SEMICOLON, TweetQlTokenKind.SEMICOLON_TOKEN, parent, start, error);
    }
}
