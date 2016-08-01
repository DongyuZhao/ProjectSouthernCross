package project.southern_cross.code_analysis.tweet_ql.config;

import project.southern_cross.code_analysis.core.annotation.SyntaxFactsClass;
import project.southern_cross.code_analysis.core.config.SyntaxFacts;

import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
@SyntaxFactsClass(language = "tweet_ql")
public class TweetQlSyntaxFacts implements SyntaxFacts {
    @Override
    public boolean isSyntaxToken(int rawKind) {
        return rawKind >= 0 && rawKind < 1000;
    }

    @Override
    public boolean isSyntaxNode(int rawKind) {
        return rawKind >= 1000 && rawKind < 7000;
    }

    @Override
    public boolean isSyntaxTrivia(int rawKind) {
        return rawKind >= 7000;
    }

    @Override
    public boolean isKeyword(String rawString) {
        return false;
    }

    @Override
    public boolean isKeyword(int rawKind) {
        return false;
    }

    @Override
    public boolean isDigit(String rawString) {
        return false;
    }

    @Override
    public boolean isOperator(int rawKind) {
        return false;
    }

    @Override
    public boolean isOperator(String rawString) {
        return false;
    }

    @Override
    public boolean isPredefinedType(String rawString) {
        return false;
    }

    @Override
    public boolean isPredefinedType(int rawKind) {
        return false;
    }

    @Override
    public int getSyntaxKind(String rawString) {
        return 0;
    }

    @Override
    public Set<String> getSpecialSymbolList() {
        return null;
    }

    @Override
    public Set<String> getChangeLineSymbols() {
        return null;
    }

    @Override
    public Set<Character> getPostDigitLabelList() {
        return null;
    }
}
