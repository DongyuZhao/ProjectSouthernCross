package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.core.SyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/1.
 */
public class TweetQlSyntaxKind extends SyntaxKind {
    public final static int CREATE_SYNTAX_TOKEN = 1;
    public final static int CREATE_SYNTAX_NODE = 1003;
    public final static int FROM_SYNTAX_TOKEN = 2;
    public final static int FROM_SYNTAX_NODE = 1004;
    public final static int SEMICOLON_TOKEN = 501;
    public final static int LEFT_PARENTHESES_TOKEN = 502;
    public final static int SOURCE_LIST_EXP_SYNTAX_NODE =1005;
    public final static int RIGHT_PARENTHESES_TOKEN = 503;
    public final static int COMMA_SYNTAX_TOKEN = 504;
}
