package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.SyntaxTokenizer;
import project.code_analysis.core.SyntaxUnit;
import project.code_analysis.tweet_ql.syntax.lexers.TweetQlSyntaxLexer;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class TweetQlSyntaxLexerSelectExpressionTest {
    @Test
    public void lexForSingleAttributeTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a FROM * WHERE t = \"u\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForStarAttributeTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT * FROM * WHERE t = \"u\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForMixedAttributeTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertNotEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT *, a FROM * WHERE t = \"u\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForMultiAttributeTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM s WHERE t = \"u\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromStarTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM * WHERE t = \"u\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromMultiSourceTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM s WHERE t = \"u\", x WHERE p = \"v\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromMixedSourceTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM * WHERE t = \"u\", x WHERE p = \"v\";"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromNoWhereTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM *;"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromMultiNoWhereTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM t, x;"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForFromMixedNoWhereTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM *, x WHERE p = \"v\";"))).stream().filter(SyntaxUnit::isError).count());
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM * WHERE p = \"v\", x;"))).stream().filter(SyntaxUnit::isError).count());
    }

    @Test
    public void lexForWhereSimpleCombinationTest() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        Assert.assertEquals(0, lexer.lex(TweetQlSyntaxTokenFactory.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM * WHERE p = \"v\" AND t = 123, x;"))).stream().filter(SyntaxUnit::isError).count());
    }
}