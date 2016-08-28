package project.code_analysis.tweet_ql.syntax.lexers;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.SyntaxUnit;
import project.code_analysis.tweet_ql.syntax.TweetQlTokenizer;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/29.
 */
public class TweetQlLexerCreateExpressionTest {
    @Test
    public void lexForSingleAttributeTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE t = \"u\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForMixedAttributeTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertNotEquals(0, lexer.lex(tokenizer.tokenize("CREATE *, a FROM * WHERE t = \"u\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromMultiSourceTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM s WHERE t = \"u\", b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForMultiAttributeTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertNotEquals(0, lexer.lex(tokenizer.tokenize("CREATE a, b FROM * WHERE t = \"u\", b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereSimpleCombinationTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE p = \"v\" AND t = 123, b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromMixedParenthesesSecondNoWhereTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE NOT (p = \"v\"), b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereSimpleParenthesesCombinationTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE (p = \"v\") AND t = 123, b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereMultiParenthesesCombinationTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE (p = \"v\") AND (t = 123), b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereComplexParenthesesCombinationTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE (p = \"v\") AND (t = 123 OR a = 798), b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereComplexParenthesesCombinationTest2() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE (p = \"v\") AND NOT (t = 123 OR (a = 798)), b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereErrorParenthesesCombinationTest() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertNotEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE (p = \"v\") AND (t = 123 OR a = 798, b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereErrorParenthesesCombinationTest2() throws Exception {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlLexer lexer = TweetQlLexer.create();
        Assert.assertNotEquals(0, lexer.lex(tokenizer.tokenize("CREATE a FROM * WHERE (p = \"v\" AND (t = 123 OR a = 798, b FROM x WHERE p = \"v\";")).stream().filter(SyntaxUnit::isError).count());
    }


}