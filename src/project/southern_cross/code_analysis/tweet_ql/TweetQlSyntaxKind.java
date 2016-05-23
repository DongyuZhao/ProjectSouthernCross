package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxKind;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxKind extends SyntaxKind {
    public final static int CREATE=1;
    public final static int SELECT=2;
    public final static int FROM=3;
    public final static int WHERE=4;
    public final static int AS=5;
    public final static int INTO=6;
    public final static int CONTAINS=7;
    public final static int TABLE=8;
    public final static int STREAM=9;
    public final static int WINDOW=10;
    public final static int EVERY=11;
    public final static int OR=12;
    public final static int AND=13;



    public HashMap<String, Integer> keyWorld = new HashMap<String, Integer>() {
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
            put(";",14);
            put(",",15);
            put("(",16);
            put(")",17);
            put(".",18);
            put(">",19);
            put("<",20);
            put("=",21);
            put("'",22);
            put("\"",23);
        }
    };

}
