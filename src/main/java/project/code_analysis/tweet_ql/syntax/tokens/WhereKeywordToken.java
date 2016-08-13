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
public class WhereKeywordToken extends SyntaxToken {
    public WhereKeywordToken() {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN);
    }

    public WhereKeywordToken(boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, missing, unexpected);
    }

    public WhereKeywordToken(int start, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, missing, unexpected);
    }

    public WhereKeywordToken(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, end, missing, unexpected);
    }

    public WhereKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected);
    }

    public WhereKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public WhereKeywordToken(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, missing, unexpected, parent);
    }

    public WhereKeywordToken(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, missing, unexpected, parent);
    }

    public WhereKeywordToken(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, end, missing, unexpected, parent);
    }

    public WhereKeywordToken(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, end, fullEnd, missing, unexpected, parent);
    }

    public WhereKeywordToken(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlTokenString.WHERE_KEYWORD, TweetQlSyntaxKind.WHERE_KEYWORD_TOKEN, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }
}
