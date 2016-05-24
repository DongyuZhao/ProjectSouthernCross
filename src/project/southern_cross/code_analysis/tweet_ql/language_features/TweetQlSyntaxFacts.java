package project.southern_cross.code_analysis.tweet_ql.language_features;

import project.southern_cross.code_analysis.SyntaxFacts;
import project.southern_cross.code_analysis.SyntaxKind;

import java.util.*;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxFacts extends SyntaxFacts {

    @Override
    public boolean isKeyword(String rawString) {
        int rawKind = getSyntaxKind(rawString);
        return isKeyword(rawKind);
    }

    @Override
    public boolean isKeyword(int rawKind) {
        return rawKind > SyntaxKind.ReservedKeyword && rawKind < SyntaxKind.PredefinedType;
    }

    @Override
    public boolean isOperator(int rawKind) {
        return rawKind > SyntaxKind.ReservedOperator;
    }

    @Override
    public boolean isPredefinedType(String rawString) {
        int rawKind = getSyntaxKind(rawString);
        return isPredefinedType(rawKind);
    }

    @Override
    public boolean isPredefinedType(int rawKind) {
        return rawKind > SyntaxKind.PredefinedType && rawKind < SyntaxKind.UserDefinedType;
    }

    @Override
    public int getSyntaxKind(String rawString){
        if (TweetQlSyntaxKind.Operator.keySet().contains(rawString)) {
            return TweetQlSyntaxKind.Operator.get(rawString);
        }
        if (TweetQlSyntaxKind.KeyWord.keySet().contains(rawString)) {
            return TweetQlSyntaxKind.KeyWord.get(rawString);
        }
        if(TweetQlSyntaxKind.PredefinedType.keySet().contains(rawString)){
            return TweetQlSyntaxKind.PredefinedType.get(rawString);
        }
        return -1;
    }

    @Override
    public String getFullString(int syntaxKind) {
        for (Map.Entry<String, Integer> entry: TweetQlSyntaxKind.KeyWord.entrySet()) {
            if (entry.getValue() == syntaxKind) {
                return entry.getKey();
            }
        }
        for (Map.Entry<String, Integer> entry: TweetQlSyntaxKind.Operator.entrySet()) {
            if (entry.getValue() == syntaxKind) {
                return entry.getKey();
            }
        }
        return "";
    }

    @Override
    public Set<String> getSpecialTokenList() {
        return TweetQlSyntaxKind.Operator.keySet();
    }

    // 
}
