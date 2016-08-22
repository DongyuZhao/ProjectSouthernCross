package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.SyntaxTokenizer;
import project.code_analysis.tweet_ql.syntax.lexers.SyntaxLexer;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class SyntaxLexerTest {
    @Test
    public void transformTokens() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        SyntaxLexer lexer = SyntaxLexer.create();
        Assert.assertEquals(13, lexer.lex(lexer.transformTokens(tokenizer.tokenize("SELECT a, b, c FROM s WHERE t = u;"))).size());
    }

    @Test
    public void lex() throws Exception {

    }

}