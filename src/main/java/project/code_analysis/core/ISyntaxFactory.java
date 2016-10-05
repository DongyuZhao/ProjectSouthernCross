package project.code_analysis.core;

import java.util.List;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */

/**
 * The interface that all of the syntax factories should implement
 * <p>
 *     A syntax factory is a class that provide the method to transform a given text to its corresponded syntax token
 *     and the method to bind the syntax trivia to the syntax tokens to ensure the toFullString() works correct.
 * </p>
 */
public interface ISyntaxFactory {
    /**
     * Transform the given plain text to its corresponded syntax token
     * @param rawString the given plain text
     * @return the transformed token
     */
    SyntaxToken buildToken(String rawString);

    /**
     * Bind trivia tokens to real tokens
     * @param rawTokenList the raw token list contains both trivia tokens and real tokens
     * @return the list of real tokens binded trivia tokens
     */
    List<SyntaxToken> bindSyntaxTrivia(List<SyntaxToken> rawTokenList);
}
