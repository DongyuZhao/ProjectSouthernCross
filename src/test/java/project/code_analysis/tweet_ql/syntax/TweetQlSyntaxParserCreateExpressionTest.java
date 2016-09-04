package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/5.
 */
public class TweetQlSyntaxParserCreateExpressionTest {
    @Test
    public void parseForSingleStreamSingleFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE t = \"u\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleStreamMultiFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND (b = \"c\");";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleStreamMultiFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND (b = \"c\") OR (c = 123);";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleStreamComplexFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForSingleStreamComplexFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }


    @Test
    public void parseForMultiStreamSingleFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE t = \"u\", b FROM a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamMultiMixedFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND (b = \"c\"), b FROM a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamMultiMixedFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND (b = \"c\") OR (c = 123), b FROM a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamComplexMixedFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123)), b FROM a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamComplexMixedFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345)), b FROM a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamMultiFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND (b = \"c\"), b FROM * WHERE (t = \"u\") AND (b = \"c\");";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamMultiFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND (b = \"c\") OR (c = 123), b FROM a WHERE (t = \"u\") AND (b = \"c\") OR (c = 123);";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamComplexFilterTest() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123)), b FROM a WHERE (t = \"u\") AND ((b = \"c\") OR (c = 123));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }

    @Test
    public void parseForMultiStreamComplexFilter2Test() throws Exception {
        ISyntaxParser parser = TweetQlSyntaxParser.create();
        String source = "CREATE a FROM * WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345)), b FROM a WHERE ((t = \"u\") AND ((b = \"c\") OR (c = 123)) OR (d = 345));";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.getRawString());
        Assert.assertEquals(source, root.getRawString());
    }
}
