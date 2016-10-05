package project.code_analysis.tweet_ql.syntax.nodes.structure_expressions;

import project.code_analysis.core.SyntaxError;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlNodeKind;
import project.code_analysis.tweet_ql.syntax.nodes.StructureExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class CreateExpression extends StructureExpression {
    public CreateExpression() {
        super(TweetQlNodeKind.CREATE_EXPRESSION);
    }

    public CreateExpression(SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, error);
    }

    public CreateExpression(int start, SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, start, error);
    }

    public CreateExpression(SyntaxNode parent, SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, parent, error);
    }

    public CreateExpression(SyntaxNode parent, int start, SyntaxError error) {
        super(TweetQlNodeKind.CREATE_EXPRESSION, parent, start, error);
    }

    /**
     * Get a list of UserDefinedStream declared by this Create Expression
     * @return the list of UserDefinedStream
     */
    public List<UserDefinedStream> getCreatedStreams() {
        ArrayList<UserDefinedStream> result = new ArrayList<>();
        this.getChildNodes().stream().filter(n -> n.getKind() == TweetQlNodeKind.USER_DEFINED_STREAM).forEach(n -> result.add((UserDefinedStream) n));
        return result;
    }
}
