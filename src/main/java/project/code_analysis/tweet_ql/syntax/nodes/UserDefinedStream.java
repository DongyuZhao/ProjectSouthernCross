package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.tokens.IdentifierToken;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class UserDefinedStream extends TweetQlSyntaxNode {
    public UserDefinedStream() {
        super(TweetQlNodeKind.USER_DEFINED_STREAM);
    }

    public UserDefinedStream(SyntaxError error) {
        super(TweetQlNodeKind.USER_DEFINED_STREAM, error);
    }

    public UserDefinedStream(int start, SyntaxError error) {
        super(TweetQlNodeKind.USER_DEFINED_STREAM, start, error);
    }

    public UserDefinedStream(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.USER_DEFINED_STREAM, parent, error);
    }

    public UserDefinedStream(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.USER_DEFINED_STREAM, parent, start, error);
    }

    /**
     * Get the identifier of the stream
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
     * Get the stream source
     * @return the stream source
     */
    public StreamSource getStreamSource() {
        if (this.hasChildNode() && this.getChildNodes().get(0).getKind() == TweetQlNodeKind.STREAM_SOURCE) {
            return (StreamSource) this.getChildNodes().get(0);
        } else {
            return new StreamSource(SyntaxError.getMissingError("StreamSourceNode"));
        }
    }
}
