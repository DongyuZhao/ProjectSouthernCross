package project.code_analysis.core;

import java.util.Set;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */

/**
 * The interface that all of the syntax facts providers should implement
 *
 * <p>
 *     A syntax facts provider should provide the methods for the tokenizer and the parser to learn language features in
 *     the current language.
 * </p>
 */
public interface ISyntaxFacts {
    /**
     * Determine if the given ISyntaxKind indicates a syntax token
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a syntax token
     */
    boolean isSyntaxToken(ISyntaxKind rawKind);

    /**
     * Determine if the given ISyntaxKind indicates a syntax node
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a syntax node
     */
    boolean isSyntaxNode(ISyntaxKind rawKind);

    /**
     * Determine if the given ISyntaxKind indicates a syntax trivia
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a syntax trivia
     */
    boolean isSyntaxTrivia(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a keyword in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a keyword
     */
    boolean isKeyword(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a keyword in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a keyword
     */
    boolean isKeyword(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a digit in this language
     * <p>
     *     The provided default implement accept most widely used data annotation and octal and hex
     * </p>
     * @param rawString the given plain text
     * @return if the given plain text indicates a digit
     */
    default boolean isDigit(String rawString) {
        return
                rawString != null &&
                        (rawString.matches("^([+-]?\\d+\\.\\d?[df]?)$") ||
                                rawString.matches("^([+-]?\\d+[dfo]?)$") ||
                                rawString.matches("^([+-]?0x[\\da-f]+)$")
                        );
    }

    /**
     * Determine if the given ISyntaxKind indicates a operator in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a operator
     */
    boolean isOperator(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a operator in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a operator
     */
    boolean isOperator(String rawString);

    /**
     * Determine if the given plain text indicates a predefined type in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a predefined type
     */
    boolean isPredefinedType(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a predefined type in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a predefined type
     */
    boolean isPredefinedType(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a special symbol in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a special symbol
     */
    boolean isSpecialSymbol(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a special symbol in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a special symbol
     */
    boolean isSpecialSymbol(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a change line symbol in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a change line symbol
     */
    boolean isChangeLineSymbol(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a change line symbol in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a change line symbol
     */
    boolean isChangeLineSymbol(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a line comment trigger in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a line comment trigger
     */
    boolean isLineCommentsTrigger(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a line comment trigger in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a line comment trigger
     */
    boolean isLineCommentsTrigger(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a block comment trigger in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a block comment trigger
     */
    boolean isBlockCommentsTrigger(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a line comment trigger in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a line comment trigger
     */
    boolean isBlockCommentsTrigger(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a block comment terminator in this language
     * @param rawString the given plain text
     * @return if the given plain text indicates a block comment terminator
     */
    boolean isBlockCommentsTerminator(String rawString);

    /**
     * Determine if the given ISyntaxKind indicates a line comment terminator in this language
     * @param rawKind the given ISyntaxKind
     * @return if the given ISyntaxKind indicates a line comment terminator
     */
    boolean isBlockCommentsTerminator(ISyntaxKind rawKind);

    /**
     * Determine if the given plain text indicates a valid identifier in this language
     * <p>
     *     The provided default implement accept most widely used data annotation
     * </p>
     * @param rawString the given plain text
     * @return if the given plain text indicates a valid identifier
     */
    default boolean isValidIdentifier(String rawString) {
        return
                rawString != null &&
                        (rawString.matches("^[_A-Za-z]+\\w*$"));
    }

    /**
     * Determine if the given plain text indicates a valid literal string in this language
     *
     * <p>
     *     The provided default implement accept most widely used data annotation
     * </p>
     * @param rawString the given plain text
     * @return if the given plain text indicates a valid literal string
     */
    default boolean isLiteralString(String rawString) {
        return
                rawString != null && (rawString.equals("") || rawString.matches("^\"\\w+\"$"));
    }

    /**
     * Get the correspond ISyntaxKind of the given raw string
     * @param rawString the given raw string
     * @return the correspond ISyntaxKind of the given raw string
     */
    ISyntaxKind getSyntaxKind(String rawString);

    /**
     * Get all of the special symbols in current language
     * @return a set of all of the special symbols
     */
    Set<String> getSpecialSymbolList();

    /**
     * Get all of the change line symbols in current language
     * @return a set of all of the change line symbols
     */
    Set<String> getChangeLineSymbols();

    /**
     * Get the name of current language
     * @return the name of current language
     */
    String getLanguage();

}
