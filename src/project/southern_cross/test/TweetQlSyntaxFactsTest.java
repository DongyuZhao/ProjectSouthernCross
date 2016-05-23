package project.southern_cross.test;

import org.junit.Test;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxFacts;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 18/05/2016.
 */
public class TweetQlSyntaxFactsTest {
    @Test
    public void isKeyword() throws Exception {

    }

    @Test
    public void getSyntaxKind() throws Exception {


        TweetQlSyntaxFacts fact = new TweetQlSyntaxFacts();
        int value = fact.getSyntaxKind("SELECT");
        int value1 = fact.getSyntaxKind("..");

        assertEquals(1,value);
        assertEquals(-1,value1);
    }

}