package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxKind;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public enum TweetQlTriviaKind implements ISyntaxKind {
    WHITE_SPACE,
    CHANGE_LINE,
    LINE_COMMENTS,
    BLOCK_COMMENTS,
}
