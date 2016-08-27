package project.code_analysis.core;

import java.util.List;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/26.
 */
public interface ISyntaxFactory {
    SyntaxToken buildToken(String rawString);

    List<SyntaxToken> bindSyntaxTrivia(List<SyntaxToken> rawTokenList);
}
