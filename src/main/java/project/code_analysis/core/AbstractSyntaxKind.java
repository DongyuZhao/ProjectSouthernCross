package project.code_analysis.core;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
/**
 * Provide the basic types that most languages would need to construct its syntax tree
 */
public enum AbstractSyntaxKind implements ISyntaxKind {
    COMPILATION_UNIT_SYNTAX,

    SYNTAX_TOKEN,
    CHANGE_LINE_TOKEN,
    COMMENTS_TEXT_TOKEN,

    SYNTAX_TRIVIA,
    WHITE_SPACE_TRIVIA,
    CHANGE_LINE_TRIVIA,
    LINE_COMMENTS_TRIVIA,
    BLOCK_COMMENTS_TRIVIA,
}
