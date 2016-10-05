package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */

/**
 * The enum provide all of the node kind in TweetQL
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

    USER_DEFINED_STREAM,
    FILTERED_STREAM,

    STREAM_SOURCE,
    STREAM_SOURCE_LIST,

    FIELD_ACCESS_EXPRESSION,
    VALUE_EXPRESSION,

    SCOPE_EXPRESSION,

    UNDETERMINED_NODE,
}
