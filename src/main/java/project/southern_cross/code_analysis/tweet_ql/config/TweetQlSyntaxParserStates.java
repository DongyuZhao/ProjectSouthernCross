package project.southern_cross.code_analysis.tweet_ql.config;

import project.southern_cross.code_analysis.core.parser.built_in.SyntaxParserStates;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/1.
 */
public class TweetQlSyntaxParserStates extends SyntaxParserStates {
    public static final int CREATE_EXPRESSION = 2;
    public static final int OBJECT_DECLARE_IN_CREATE = 3;
    public static final int COMMA_AFTER_OBJECT_IN_CREATE = 4;
    public static final int FROM_EXP = 5;
    public static final int OBJECT_DECLARE_IN_FROM = 6;
    public static final int IN_SOURCE_LIST = 7;
    public static final int OBJECT_DECLARE_IN_SOURCE_LIST = 8;
    public static final int COMMA_AFTER_OBJECT_IN_SOURCE_LIST = 9;
}
