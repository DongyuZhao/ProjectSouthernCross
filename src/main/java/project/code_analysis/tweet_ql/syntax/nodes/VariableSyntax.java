package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.IdentifierToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class VariableSyntax extends EvaluableExpression {
    private String variableName;

    public VariableSyntax(String typeName, String variableName) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, missing, unexpected);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, missing, unexpected);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, parent, missing, unexpected);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, parent, start, missing, unexpected);
        this.variableName = variableName;
    }

    public IdentifierToken getIdentifier() {
        if (this.hasChildNode() && (this.getChildTokens().get(0).getKind() == TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN || this.getChildTokens().get(0).getKind() == TweetQlSyntaxTokenKind.STAR_TOKEN)) {
            return (IdentifierToken) this.getChildTokens().get(0);
        }
        return null;
    }

    public String getVariableName() {
        return this.variableName;
    }

    public StreamFilterExpressionSyntax getStreamFilter() {
        if (this.hasChildNode() && this.getChildNodes().get(0).getKind() == TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE) {
            return (StreamFilterExpressionSyntax) this.getChildNodes().get(0);
        }
        return new StreamFilterExpressionSyntax();
    }
}
