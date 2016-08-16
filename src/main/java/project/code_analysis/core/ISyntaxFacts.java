package project.code_analysis.core;

import java.util.Set;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public interface ISyntaxFacts {
    boolean isSyntaxToken(ISyntaxKind rawKind);

    boolean isSyntaxNode(ISyntaxKind rawKind);

    boolean isSyntaxTrivia(ISyntaxKind rawKind);

    boolean isKeyword(String rawString);

    boolean isKeyword(ISyntaxKind rawKind);

    default boolean isDigit(String rawString) {
        return
                rawString != null &&
                        (rawString.matches("^([+-]?\\d+\\.\\d?[df]?)$") ||
                                rawString.matches("^([+-]?\\d+[dfo]?)$") ||
                                rawString.matches("^([+-]?0x[\\da-f]+)$"))
                ;
    }

    boolean isOperator(ISyntaxKind rawKind);

    boolean isOperator(String rawString);

    boolean isPredefinedType(String rawString);

    boolean isPredefinedType(ISyntaxKind rawKind);

    boolean isSpecialSymbol(String rawString);

    boolean isSpecialSymbol(ISyntaxKind rawKind);

    boolean isChangeLineSymbol(String rawString);

    boolean isChangeLineSymbol(ISyntaxKind rawKind);

    default boolean isValidIdentifier(String rawString) {
        return
                rawString != null &&
                        (rawString.matches("^[_A-Za-z]+\\w?$"));
    }

    default boolean isLiteralString(String rawString) {
        return
                rawString != null && (rawString.equals("") || rawString.matches("^\"\\w+\"$"));
    }

    ISyntaxKind getSyntaxKind(String rawString);

    Set<String> getSpecialSymbolList();

    Set<String> getChangeLineSymbols();

}
