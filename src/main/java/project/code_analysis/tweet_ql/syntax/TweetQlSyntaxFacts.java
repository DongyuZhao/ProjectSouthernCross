package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.ISyntaxFacts;
import project.code_analysis.core.ISyntaxKind;

import java.util.Set;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class TweetQlSyntaxFacts implements ISyntaxFacts {
    @Override
    public boolean isSyntaxToken(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isSyntaxNode(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isSyntaxTrivia(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isKeyword(String rawString) {
        return false;
    }

    @Override
    public boolean isKeyword(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isOperator(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public boolean isOperator(String rawString) {
        return false;
    }

    public boolean isUnaryOperator(ISyntaxKind rawKind) {
        return false;
    }

    public boolean isUnaryOperator(String rawString) {
        return false;
    }

    public boolean isBinaryOperator(ISyntaxKind rawKind) {
        return false;
    }

    public boolean isBinaryOperator(String rawString) {
        return false;
    }

    public boolean isBoolOperator(ISyntaxKind rawKind) {
        return false;
    }

    public boolean isBoolOperator(String rawString) {
        return false;
    }

    @Override
    public boolean isPredefinedType(String rawString) {
        return false;
    }

    @Override
    public boolean isPredefinedType(ISyntaxKind rawKind) {
        return false;
    }

    @Override
    public ISyntaxKind getSyntaxKind(String rawString) {
        return null;
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
