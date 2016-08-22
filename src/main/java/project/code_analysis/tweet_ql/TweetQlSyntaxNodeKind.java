package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public enum  TweetQlSyntaxNodeKind implements ISyntaxKind {
    COMPILE_UNIT_NODE,
    CREATE_EXPRESSION_NODE,
    SELECT_EXPRESSION_NODE,
    USER_DEFINED_TYPE_NODE,
    STREAM_LIST_NODE,
    ATTRIBUTE_LIST_NODE,
    STREAM_FILTER_EXPRESSION_NODE,
    UNARY_EXPRESSION,
    BINARY_EXPRESSION,
}
