package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxFacts;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Iterator;
import java.util.HashMap;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxFacts extends SyntaxFacts {
    public boolean isKeyword(String rawString) {

        TweetQlSyntaxKind kind=new TweetQlSyntaxKind();
        HashMap<String, Integer> hashmap=kind.keyWorld;
        Iterator it = hashmap.keySet().iterator();
        while(it.hasNext()) {
            String key = (String)it.next();
            if(key == rawString) {
                return true;

            }
        }
        return false;
    }

    /**
     *
     * @param rawString
     * if rawString is key word, return its type,
     * else return -1 (Undetermined)
     */
    public int getSyntaxKind(String rawString){

        TweetQlSyntaxKind kind=new TweetQlSyntaxKind();
        HashMap<String, Integer> hashmap=kind.keyWorld;
        Iterator it = hashmap.keySet().iterator();
        while(it.hasNext()) {
            String key = (String)it.next();
            if(key == rawString) {
               int value = hashmap.get(key);
                return value;
            }
        }
        return -1;
    }

    // 
}
