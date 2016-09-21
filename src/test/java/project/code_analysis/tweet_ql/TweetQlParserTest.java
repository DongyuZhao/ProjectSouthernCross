package project.code_analysis.tweet_ql;

import org.junit.Test;
import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.syntax.nodes.CreateExpression;
import project.code_analysis.tweet_ql.syntax.nodes.EvaluableExpression;
import project.code_analysis.tweet_ql.syntax.nodes.SelectExpression;
import project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions.BinaryExpression;
import project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions.FieldAccessExpression;
import project.code_analysis.tweet_ql.syntax.nodes.evaluable_expressions.ValueExpression;

import java.util.ArrayList;
import java.util.List;

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
                        source.getFilterConditions().getDescentNodesOrSelf().stream().filter(n -> n.getKind() == TweetQlNodeKind.FIELD_ACCESS_EXPRESSION).forEach(n -> System.out.println(((FieldAccessExpression) n).getFieldName()));
                        source.getFilterConditions().getDescentNodesOrSelf().stream().filter(n -> n.getKind() == TweetQlNodeKind.VALUE_EXPRESSION).forEach(n -> System.out.println(((ValueExpression) n).getValue()));

                    });
                    break;
            }
        });
    }

    @Test
    public void TweetQlParserUsageTest2() {
        TweetQlSyntaxTree tree = TweetQlSyntaxTree.parseText("SELECT * FROM * WHERE lang = \"ar\";");
        List<String> targetAttributeList = new ArrayList<String>();
        List<String> operateList = new ArrayList<String>();
        List<String> ExpectedValueList = new ArrayList<String>();
        CompilationUnitSyntax root = tree.getRoot();
        root.getChildNodes().forEach(node -> {
            switch ((TweetQlNodeKind) node.getKind()) {
                case SELECT_EXPRESSION:
                    SelectExpression selectExpression = (SelectExpression) node;
                    selectExpression.getStreamSourceList().getStreamSources().forEach(source -> {
                        System.out.println(source.getStreamIdentifier());
                        System.out.println(source.getFilterConditions());
                        EvaluableExpression condition = source.getFilterConditions();
                        if (condition.getKind() == TweetQlNodeKind.BINARY_EXPRESSION) {
                            BinaryExpression binaryExpression = (BinaryExpression) condition;
                            operateList.add(binaryExpression.getOperator().getRawString());
                            targetAttributeList.add(((FieldAccessExpression) binaryExpression.getLeftSubExpression()).getFieldName());
                            ExpectedValueList.add(((ValueExpression) binaryExpression.getRightSubExpression()).getValue());
                        }
                    });
                    break;
            }
        });
        System.out.println(operateList.get(0));
        System.out.println(targetAttributeList.get(0));
        System.out.println(ExpectedValueList.get(0));
    }
}
