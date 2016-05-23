package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SyntaxFacts;
import project.southern_cross.code_analysis.SyntaxKind;

import java.util.*;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxFacts extends SyntaxFacts {
    private static ArrayList<String> specialTokenList = new ArrayList<String>() {{
        add(".");
        add("+");
        add("-");
        add("*");
        add("/");
        add("%");
        add("&");
        add("~");
        add("|");
        add("^");
        add("=");
        add("=>");
    }};

    @Override
    public boolean isKeyword(String rawString) {
        int rawKind = getSyntaxKind(rawString);
        return isKeyword(rawKind);
    }

    @Override
    protected boolean isKeyword(int rawKind) {
        return rawKind > SyntaxKind.ReservedKeyword && rawKind < SyntaxKind.PredefinedType;
    }

    @Override
    public boolean isPredefinedType(String rawString) {
        int rawKind = getSyntaxKind(rawString);
        return isPredefinedType(rawKind);
    }

    @Override
    protected boolean isPredefinedType(int rawKind) {
        return rawKind > SyntaxKind.PredefinedType && rawKind < SyntaxKind.UserDefinedType;
    }

    @Override
    public int getSyntaxKind(String rawString){
        return TweetQlSyntaxKind.KeyWord.getOrDefault(rawString, -1);
    }

    @Override
    public String getFullString(int syntaxKind) {
        for (Map.Entry<String, Integer> entry: TweetQlSyntaxKind.KeyWord.entrySet()) {
            if (entry.getValue() == syntaxKind) {
                return entry.getKey();
            }
        }
        return "";
    }

    @Override
    public ArrayList<String> getSpecialTokenList() {
        return specialTokenList;
    }

    // 
}
