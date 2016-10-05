package project.code_analysis.tweet_ql.syntax.tokens.trivia;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;
import project.code_analysis.tweet_ql.syntax.tokens.TriviaToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */

/**
 * A syntax token class holds "\r\n"
 */
public class CRLFToken extends TriviaToken {
    public CRLFToken() {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN);
    }

    public CRLFToken(SyntaxError error) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, error);
    }

    public CRLFToken(int start, SyntaxError error) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, start, error);
    }

    public CRLFToken(SyntaxNode parent, SyntaxError error) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, parent, error);
    }

    public CRLFToken(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlTokenString.CRLF, TweetQlTokenKind.CRLF_TOKEN, parent, start, error);
    }
}
