package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.IdentifierToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class VariableSyntax extends EvaluableExpression {
    private String variableName;

    public VariableSyntax(String typeName, String variableName) {
        super(TweetQlNodeKind.USER_DEFINED_TYPE);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.USER_DEFINED_TYPE, missing, unexpected);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.USER_DEFINED_TYPE, start, missing, unexpected);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.USER_DEFINED_TYPE, parent, missing, unexpected);
        this.variableName = variableName;
    }

    public VariableSyntax(String typeName, String variableName, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(TweetQlNodeKind.USER_DEFINED_TYPE, parent, start, missing, unexpected);
        this.variableName = variableName;
    }

    public IdentifierToken getIdentifier() {
        if (this.hasChildNode() && (this.getChildTokens().get(0).getKind() == TweetQlTokenKind.IDENTIFIER_TOKEN || this.getChildTokens().get(0).getKind() == TweetQlTokenKind.STAR_TOKEN)) {
            return (IdentifierToken) this.getChildTokens().get(0);
        }
        return null;
    }

    public String getVariableName() {
        return this.variableName;
    }

    public StreamFilterExpressionSyntax getStreamFilter() {
        if (this.hasChildNode() && this.getChildNodes().get(0).getKind() == TweetQlNodeKind.STREAM_FILTER_EXPRESSION) {
            return (StreamFilterExpressionSyntax) this.getChildNodes().get(0);
        }
        return new StreamFilterExpressionSyntax();
    }
}
