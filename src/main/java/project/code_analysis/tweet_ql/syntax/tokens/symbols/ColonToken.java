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
 * A syntax token class holds ":"
 */
public class ColonToken extends SymbolToken {
    public ColonToken() {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN);
    }

    public ColonToken(SyntaxError error) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, error);
    }

    public ColonToken(int start, SyntaxError error) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, start, error);
    }

    public ColonToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, parent, error);
    }

    public ColonToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.COLON, TweetQlTokenKind.COLON_TOKEN, parent, start, error);
    }
}
