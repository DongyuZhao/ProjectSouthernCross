package project.southern_cross.code_analysis_v2;

import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public abstract class SyntaxFacts {
    public abstract boolean isKeyword(String rawString);

    protected abstract boolean isKeyword(int rawKind);

    protected abstract boolean isOperator(int rawKind);

    public abstract boolean isOperator(String rawString);

    public abstract boolean isPredefinedType(String rawString);

    protected abstract boolean isPredefinedType(int rawKind);

    public abstract int getSyntaxKind(String rawString);

    public abstract String getFullString(int syntaxKind);

    public abstract Set<String> getSpecialTokenList();
}