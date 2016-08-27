package project.code_analysis.tweet_ql;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/23.
 */
public class TweetQlSyntaxTreeTest {
    @Test
    public void Test() {
        String source = "SELECT a, b, c FROM *;";
        TweetQlSyntaxTree tree = TweetQlSyntaxTree.parseText(source);
        Assert.assertEquals(source, tree.getRoot().getRawString());
    }
}