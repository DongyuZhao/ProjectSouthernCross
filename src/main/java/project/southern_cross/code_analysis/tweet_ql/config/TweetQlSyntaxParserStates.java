package project.southern_cross.code_analysis.tweet_ql.config;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/1.
 */
public class TweetQlSyntaxParserStates {
    public static final int NULL = -1;
    public static final int ROOT = 0;
    public static final int CREATE_EXPRESSION = 1;
    public static final int OBJECT_DECLARE_IN_CREATE = 2;
    public static final int COMMA_AFTER_OBJECT_IN_CREATE = 3;
}
