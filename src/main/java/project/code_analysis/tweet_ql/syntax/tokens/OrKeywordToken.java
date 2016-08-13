package project.code_analysis.tweet_ql.syntax.tokens;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.TweetQlTokenString;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class OrKeywordToken extends SyntaxToken {
    public OrKeywordToken() {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN);
    }

    public OrKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, missing, unexpected);
    }

    public OrKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public OrKeywordToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, end, missing, unexpected);
    }

    public OrKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public OrKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public OrKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public OrKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }

    public OrKeywordToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, end, missing, unexpected, parent);
    }

    public OrKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public OrKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.OR_KEYWORD, TweetQlSyntaxKind.OR_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
