package project.southern_cross.code_analysis;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SyntaxFacts {
    public abstract boolean isKeyword(String rawString);

    protected abstract boolean isKeyword(int rawKind);

    protected abstract boolean isOperator(int rawKind);

    public abstract boolean isPredefinedType(String rawString);

    protected abstract boolean isPredefinedType(int rawKind);

    public abstract int getSyntaxKind(String rawString);

    public abstract String getFullString(int syntaxKind);

    public abstract ArrayList<String> getSpecialTokenList();
}
