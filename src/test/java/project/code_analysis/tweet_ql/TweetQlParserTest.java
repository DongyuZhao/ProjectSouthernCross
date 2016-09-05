package project.code_analysis.tweet_ql;

import org.junit.Test;
import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.syntax.nodes.CreateExpression;
import project.code_analysis.tweet_ql.syntax.nodes.SelectExpression;
import project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions.BinaryExpression;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/5.
 */
public class TweetQlParserTest {
    @Test
    public void TweetQlParserUsageTest() {
        TweetQlSyntaxTree tree = TweetQlSyntaxTree.parseText("SELECT a, b FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345)), a WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345));");
        CompilationUnitSyntax root = tree.getRoot();
        root.getChildNodes().forEach(node -> {
            switch ((TweetQlNodeKind) node.getKind()) {
                case CREATE_EXPRESSION:
                    CreateExpression createExpression = (CreateExpression) node;
                    createExpression.getCreatedStreams().forEach(stream -> {
                        System.out.println(stream.getStreamIdentifier());
                        System.out.println(stream.getStreamSource().getStreamIdentifier());
                        System.out.println(stream.getStreamSource().getFilterConditions());
                    });
                    break;
                case SELECT_EXPRESSION:
                    SelectExpression selectExpression = (SelectExpression) node;
                    selectExpression.getAttributeList().getAttributes().forEach(System.out::println);
                    selectExpression.getStreamSourceList().getStreamSources().forEach(source -> {
                        System.out.println(source.getStreamIdentifier());
                        System.out.println(source.getFilterConditions());
                        source.getFilterConditions().getDescentNodesOrSelf().stream().filter(n -> n.getKind() == TweetQlNodeKind.BINARY_EXPRESSION).forEach(n -> System.out.println(((BinaryExpression) n).getOperator()));
                    });
                    break;
            }
        });
    }
}
