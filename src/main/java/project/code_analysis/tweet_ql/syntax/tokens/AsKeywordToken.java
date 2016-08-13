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
public class AsKeywordToken extends SyntaxToken {
    public AsKeywordToken() {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN);
    }

    public AsKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, missing, unexpected);
    }

    public AsKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public AsKeywordToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, end, missing, unexpected);
    }

    public AsKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public AsKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public AsKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public AsKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }

    public AsKeywordToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, end, missing, unexpected, parent);
    }

    public AsKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public AsKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.AS_KEYWORD, TweetQlSyntaxKind.AS_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
