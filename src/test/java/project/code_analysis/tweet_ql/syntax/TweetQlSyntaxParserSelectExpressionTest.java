package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/16.
 */
public class TweetQlSyntaxParserSelectExpressionTest {
    @Test
    public void parseForSingleAttributeSingleFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a FROM * WHERE t = \"u\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleAttributeMultiFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a FROM * WHERE (t = \"u\") AND (b = \"c\");";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleAttributeMultiFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a FROM * WHERE (t = \"u\") AND (b = \"c\") OR (c = 123);";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleAttributeComplexFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a FROM * WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleAttributeComplexFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }


    @Test
    public void parseForMultiAttributeSingleFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeMultiMixedFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE (t = \"u\") AND (b = \"c\"), a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeMultiMixedFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE (t = \"u\") AND (b = \"c\") OR (c = 123), a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeComplexMixedFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123)), a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeComplexMixedFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345)), a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeMultiFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE (t = \"u\") AND (b = \"c\"), * WHERE (t = \"u\") AND (b = \"c\");";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeMultiFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE (t = \"u\") AND (b = \"c\") OR (c = 123), a WHERE (t = \"u\") AND (b = \"c\") OR (c = 123);";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeComplexFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123)), a WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiAttributeComplexFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "SELECT a, b FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345)), a WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }
}