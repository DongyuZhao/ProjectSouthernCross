package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public interface ISyntaxFactory {
    SyntaxToken buildToken(String rawString);

    SyntaxTrivia buildTrivia(String rawString);
}
