package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxKind;

/**
 * The enum provide all of the trivia kind in TweetQL
 */
public enum TweetQlTriviaKind implements ISyntaxKind {
    WHITE_SPACE,
    CHANGE_LINE,
    LINE_COMMENTS,
    BLOCK_COMMENTS,
}
