package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public enum TweetQlNodeKind implements ISyntaxKind {
    COMPILE_UNIT,
    CREATE_EXPRESSION,
    SELECT_EXPRESSION,
    USER_DEFINED_TYPE,
    STREAM_LIST,
    ATTRIBUTE_LIST,
    STREAM_FILTER_EXPRESSION,
    UNARY_EXPRESSION,
    BINARY_EXPRESSION,
}
