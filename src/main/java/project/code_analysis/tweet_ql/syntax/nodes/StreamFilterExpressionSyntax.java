package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamFilterExpressionSyntax extends TweetQlSyntaxNode {
    public StreamFilterExpressionSyntax() {
        super(TweetQlNodeKind.STREAM_FILTER_EXPRESSION);
    }

    public StreamFilterExpressionSyntax(SyntaxError error) {
        super(TweetQlNodeKind.STREAM_FILTER_EXPRESSION, error);
    }

    public StreamFilterExpressionSyntax(int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_FILTER_EXPRESSION, start, error);
    }

    public StreamFilterExpressionSyntax(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_FILTER_EXPRESSION, parent, error);
    }

    public StreamFilterExpressionSyntax(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_FILTER_EXPRESSION, parent, start, error);
    }

    public String getExpectedValue() {
        if (this.hasChildToken() && this.getChildTokens().size() == 3) {
            return this.getChildTokens().get(2).getRawString();
        }
        return "";
    }

    public String getOperator() {
        if (this.hasChildToken() && this.getChildTokens().size() == 3) {
            return this.getChildTokens().get(1).getRawString();
        }
        return "";
    }

    public String getAttributeName() {
        if (this.hasChildToken()) {
            return this.getChildTokens().get(0).getRawString();
        }
        return "";
    }
}
