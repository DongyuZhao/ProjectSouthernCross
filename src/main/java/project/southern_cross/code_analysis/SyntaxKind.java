package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxKind {
    public final static int UN_DETERMINED_SYNTAX_TOKEN = 0;
    public final static int UN_DETERMINED_SYNTAX_NODE = 1000;
    public final static int ROOT = 1001;
    public final static int RESERVED_KEYWORD_SYNTAX_NODE = 1002;
    public final static int PREDEFINED_TYPE_SYNTAX_NODE = 2000;
    public final static int USER_DEFINED_TYPE_SYNTAX_NODE = 2001;
    public final static int DECLARATION_SYNTAX_NODE = 3000;
    public final static int DOMAIN_SYNTAX_NODE = 4000;
    public final static int OPERATOR_SYNTAX_NODE = 5000;
    public final static int EXPRESSION_SYNTAX_NODE = 6000;
    public final static int COMMENT_SYNTAX_TRIVIA = 7000;
    public final static int ERROR = -1;
}
