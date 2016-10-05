package project.code_analysis.tweet_ql.syntax.nodes.structure_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;
import project.code_analysis.tweet_ql.syntax.nodes.StructureExpression;
import project.code_analysis.tweet_ql.syntax.tokens.data.IdentifierToken;

/**
 * A syntax node class holds stream source
 */
public class StreamSource extends StructureExpression {
    public StreamSource() {
        super(TweetQlNodeKind.STREAM_SOURCE);
    }

    public StreamSource(SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE, error);
    }

    public StreamSource(int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE, start, error);
    }

    public StreamSource(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE, parent, error);
    }

    public StreamSource(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.STREAM_SOURCE, parent, start, error);
    }

    /**
     * Get the identifier of this stream
     * @return the identifier
     */
    public IdentifierToken getStreamIdentifier() {
        if (this.hasChildToken() && IdentifierToken.isIdentifier(this.getChildTokens().get(0))) {
            return (IdentifierToken) this.getChildTokens().get(0);
        } else {
            return new IdentifierToken("", SyntaxError.getMissingError("IdentifierToken"));
        }
    }

    /**
     * Get the filter conditions
     * @return the filter conditions
     */
    public EvaluableExpression getFilterConditions() {
        if (this.hasChildNode() && EvaluableExpression.isEvaluable(this.getChildNodes().get(0))) {
            return (EvaluableExpression) this.getChildNodes().get(0);
        } else {
            return new EvaluableExpression(TweetQlNodeKind.UNDETERMINED_NODE, SyntaxError.getMissingError("EvaluableExpression"));
        }
    }
}
