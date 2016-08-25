package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class StreamFilterExpressionSyntax extends TweetQlSyntaxNode {
    public StreamFilterExpressionSyntax() {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected);
    }

    public StreamFilterExpressionSyntax( boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, missing, unexpected, parent);
    }

    public StreamFilterExpressionSyntax( int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE, start, missing, unexpected, parent);
    }

    public String getExpectedValue() {
        if (this.hasChildToken() && this.getChildTokens().size() == 2) {
            return this.getChildTokens().get(2).getRawString();
        }
        return "";
    }

    public String getOperator() {
        if (this.hasChildToken() && this.getChildTokens().size() == 2) {
            return this.getChildTokens().get(1).getRawString();
        }
        return "";
    }

    @Override
    public String getRawString() {
        if (!this.getAttributeName().equals("")) {
            StringBuilder builder = new StringBuilder();
            builder.append(" WHERE ");
            this.getChildTokens().forEach(t -> {
                builder.append(t.getRawString());
                builder.append(" ");
            });
            if (builder.charAt(builder.length() - 1) == ' ') {
                builder.delete(builder.length() - 1, builder.length());
            }
            return builder.toString();
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
