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
    public final static int NOT=13;

    public final static int TwitterStream = 1001;
    public final static int IntegerType = 1002;
    public final static int FloatType = 1003;
    public final static int DateType = 1004;


    public final static int DotAccessOperator = 3001;
    public final static int PlusOperator = 3002;
    public final static int MinusOperator = 3003;
    public final static int MultipleOperator = 3004;
    public final static int DivideOperator = 3005;
    public final static int ModOperator = 3006;
    public final static int PowerOperator = 3007;
    public final static int LogicAndOperator = 3008;
    public final static int LogicOrOperator = 3009;
    public final static int LogicNotOperator = 3010;
    public final static int EqualOperator = 3011;
    public final static int AssignOperator = 3012;
    public final static int LambdaOperator = 3013;
    public final static int SingleQuote = 3014;
    public final static int DoubleQuote = 3015;
    public final static int SemiColon = 3016;
    public final static int Comma = 3017;
    public final static int LeftBracket = 3018;
    public final static int RightBracket = 3019;


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
            put("NOT", NOT);
        }
    };

    public static HashMap<String, Integer> Operator = new HashMap<String, Integer>() {
        {
            put(".", DotAccessOperator);
            put("+", PlusOperator);
            put("-", MinusOperator);
            put("*", MultipleOperator);
            put("/", DivideOperator);
            put("%", ModOperator);
            put("^", PowerOperator);
            put("&&", LogicAndOperator);
            put("||", LogicOrOperator);
            put("!", LogicNotOperator);
            put("==", EqualOperator);
            put("=", AssignOperator);
            put("=>", LambdaOperator);
            put("\'", SingleQuote);
            put("\"", DoubleQuote);
            put(";", SemiColon);
            put(",", Comma);
            put("(", LeftBracket);
            put(")", RightBracket);
        }
    };

    public static HashMap<String, Integer> PredefinedType = new HashMap<String, Integer>() {
        {
            put("twitter_stream", TwitterStream);
        }
    };
}