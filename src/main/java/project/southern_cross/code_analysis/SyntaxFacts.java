package project.southern_cross.code_analysis;

import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/16.
 */
public interface SyntaxFacts {
    boolean isSyntaxToken(int rawKind);

    boolean isSyntaxNode(int rawKind);

    boolean isKeyword(String rawString);

    boolean isKeyword(int rawKind);

    boolean isDigit(String rawString);

    boolean isOperator(int rawKind);

    boolean isOperator(String rawString);

    boolean isPredefinedType(String rawString);

    boolean isPredefinedType(int rawKind);

    int getSyntaxKind(String rawString);

    Set<String> getSpecialSymbolList();

    Set<String> getChangeLineSymbols();

    Set<Character> getPostDigitLabelList();
}
