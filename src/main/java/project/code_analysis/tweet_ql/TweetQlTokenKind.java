package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public enum TweetQlTokenKind implements ISyntaxKind {
    //region SyntaxTokenKind
    CREATE_KEYWORD,
    SELECT_KEYWORD,
    FROM_KEYWORD,
    WHERE_KEYWORD,
    CONTAIN_KEYWORD,
    LIKE_KEYWORD,
    AND_KEYWORD,
    OR_KEYWORD,
    NOT_KEYWORD,
    SKIP_KEYWORD,
    WINDOW_KEYWORD,
    AS_KEYWORD,
    BETWEEN_KEYWORD,
    ORDER_KEYWORD,
    BY_KEYWORD,
    ASCEND_KEYWORD,
    DESCEND_KEYWORD,

    OPEN_PARENTHESES,
    CLOSE_PARENTHESES,
    OPEN_BRACKET,
    CLOSE_BRACKET,
    OPEN_BRACE,
    CLOSE_BRACE,

    COMMA_TOKEN,
    DOT_TOKEN,
    COLON_TOKEN,
    SEMICOLON_TOKEN,

    EQUAL_TOKEN,
    BIGGER_TOKEN,
    LESS_TOKEN,
    BIGGER_EQUAL_TOKEN,
    LESS_EQUAL_TOKEN,

    CRLF_TOKEN,
    LF_TOKEN,

    STAR_TOKEN,

    DIGIT_TOKEN,

    IDENTIFIER_TOKEN,
    LITERAL_STRING_TOKEN,

    DOUBLE_SLASH_TOKEN,
    SLASH_STAR_TOKEN,
    STAR_SLASH_TOKEN,


    UNDETERMINED_TOKEN,
    WHITE_SPACE_TOKEN,
    //endregion


}
