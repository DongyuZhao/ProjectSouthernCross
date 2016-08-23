package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.syntax.CompilationUnitSyntax;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class TweetQlSyntaxParserSelectExpressionTest {
    @Test
    public void parseForSingleAttributeTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForStarAttributeTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT * FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMixedAttributeTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT *, a FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals("", root.getRawString());
    }

    @Test
    public void parseForMultiAttributeTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForFromStarSourceTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b, c FROM * WHERE t = \"u\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForFromMultiSourceTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b, c FROM s WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForFromMixedSourceTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b, c FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForFromNoWhereTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b, c FROM *;";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForFromMultiNoWhereTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b, c FROM s, a;";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForFromMixedNoWhereTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b, c FROM * WHERE p = \"v\", x;";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }
}