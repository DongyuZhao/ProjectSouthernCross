package tweet_ql.language_features.syntax;

import project.southern_cross.code_analysis_v2.SyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/12.
 */
public class TweetQlTokenKind extends SyntaxKind {
    //region symbol tokens
    // any new symbol should be added to this region, with a unique type id from 1 to 399
    public final static int CHANGE_LINE = 1;
    public final static int COMMA = 2;
    public final static int SEMICOLON = 3;
    public final static int LEFT_BRACKET = 4;
    public final static int RIGHT_BRACKET = 5;
    public final static int LEFT_PARENTHESIS = 6;
    public final static int RIGHT_PARENTHESIS = 7;
    public final static int SINGLE_QUOTE = 8;
    public final static int DOUBLE_QUOTE = 9;
    public final static int EQUAL_OPERATOR = 10;
    public final static int NOT_EQUAL_OPERATOR = 11;
    public final static int MORE_THAN_OPERATOR = 12;
    public final static int MORE_OR_EQUAL_OPERATOR = 13;
    public final static int LESS_THAN_OPERATOR = 14;
    public final static int LESS_OR_EQUAL_OPERATOR = 15;
    public final static int LOGIC_AND_OPERATOR = 16;
    public final static int LOGIC_OR_OPERATOR = 17;
    public final static int LOGIC_NO_OPERATOR = 18;
    public final static int BIT_AND_OPERATOR = 19;
    public final static int BIT_OR_OPERATOR = 20;
    public final static int BIT_NOR_OPERATOR = 21;
    public final static int BIT_NAND_OPERATOR = 22;
    public final static int BIT_REVERSE_OPERATOR = 23;
    public final static int PLUS_OPERATOR = 24;
    public final static int MINUS_OPERATOR = 25;
    public final static int MULTIPLY_OPERATOR = 26;
    public final static int DIVIDE_OPERATOR = 27;
    public final static int POWER_OPERATOR = 28;
    public final static int MOD_OPERATOR = 29;
    public final static int ASSIGN_OPERATOR = 30;
    public final static int DOT_ACCESS_OPERATOR = 31;
    public final static int NARROW_ARROW_ACCESS_OPERATOR =32;
    public final static int WIDE_ARROW_ACCESS_OPERATOR = 33;
    // add here
    //endregion 

    //region keyword tokens
    // any new keyword should be added to this region, with a unique type id from 400 to 799
    public final static int CREATE_KEYWORD = 400;
    public final static int SELECT_KEYWORD = 401;
    public final static int FROM_KEYWORD = 402;
    public final static int WHERE_KEYWORD = 403;
    public final static int AS_KEYWORD = 404;
    public final static int INTO_KEYWORD = 405;
    public final static int CONTAINS_KEYWORD = 406;
    public final static int WITH_KEYWORD = 407;
    public final static int EVERY_KEYWORD = 408;
    public final static int WINDOW_KEYWORD = 409;
    public final static int AND_KEYWORD = 410;
    public final static int OR_KEYWORD = 411;
    public final static int NOT_KEYWORD = 412;
    public final static int NOR_KEYWORD = 413;
    public final static int NAND_KEYWORD = 414;
    public final static int INNER_KEYWORD = 415;
    public final static int OUTER_KEYWORD = 416;
    public final static int JOIN_KEYWORD = 417;
    public final static int COUNT_KEYWORD = 418;
    public final static int NO_KEYWORD = 419;
    public final static int TABLE_KEYWORD = 420;
    public final static int STREAM_KEYWORD = 421;
    // add here
    //endregion

    //region predefined type tokens
    // any new predefined type should be added to this region, with a unique type id from 800 to 999
    public final static int TWITTER_STREAM = 800;
    // add here
    //endregion
}
