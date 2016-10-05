package project.code_analysis.tweet_ql.syntax.tokens;

/**
 * Created by Dy.Zhao on 10/5/2016.
 */

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;

/**
 * A common parent of all of the trivia tokens in TweetQL
 */
public class TriviaToken extends TweetQlSyntaxToken {
    public TriviaToken(String rawString, ISyntaxKind kind) {
        super(rawString, kind);
    }

    public TriviaToken(String rawString, ISyntaxKind kind, SyntaxError error) {
        super(rawString, kind, error);
    }

    public TriviaToken(String rawString, ISyntaxKind kind, int start, SyntaxError error) {
        super(rawString, kind, start, error);
    }

    public TriviaToken(String rawString, ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(rawString, kind, parent, error);
    }

    public TriviaToken(String rawString, ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(rawString, kind, parent, start, error);
    }
}
