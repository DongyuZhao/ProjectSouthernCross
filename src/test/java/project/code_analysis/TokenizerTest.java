package project.code_analysis;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.SyntaxTokenizer;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/21.
 */
public class TokenizerTest {
    @Test
    public void tokenize() throws Exception {
        SyntaxTokenizer tokenizer = SyntaxTokenizer.create(TweetQlSyntaxFacts.getInstance());
        Assert.assertEquals(13, tokenizer.tokenize("SELECT a, b, c FROM s WHERE t = u;").size());
    }

}