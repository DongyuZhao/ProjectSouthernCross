package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SyntaxKind;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxKind extends SyntaxKind {
    public final static int CREATE=0;
    public final static int SELECT=1;
    public final static int FROM=2;
    public final static int WHERE=3;
    public final static int AS=4;
    public final static int INTO=5;
    public final static int CONTAINS=6;
    public final static int TABLE=7;
    public final static int STREAM=8;
    public final static int WINDOW=9;
    public final static int EVERY=10;
    public final static int OR=11;
    public final static int AND=12;

    public static HashMap<String, Integer> KeyWord = new HashMap<String, Integer>() {
        {
            put("CREATE", CREATE);
            put("SELECT",SELECT);
            put("FROM",FROM);
            put("WHERE",WHERE);
            put("AS",AS);
            put("INTO",INTO);
            put("CONTAINS",CONTAINS);
            put("TABLE",TABLE);
            put("STREAM",STREAM);
            put("WINDOW",WINDOW);
            put("EVERY",EVERY);
            put("OR",OR);
            put("AND",AND);
        }
    };

}
