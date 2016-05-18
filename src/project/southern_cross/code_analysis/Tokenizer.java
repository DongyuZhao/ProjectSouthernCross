package project.southern_cross.code_analysis;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class Tokenizer {
    enum TokenizerStates {
        leadingSpace,
        trialingSpace,
        text,
        specialToken
    }

    public static ArrayList<SyntaxToken> tokenize(String text, ArrayList<String> specialTokenList){
        ArrayList<SyntaxToken> tokenList = new ArrayList<>();
        TokenizerStates state = TokenizerStates.leadingSpace;
        StringBuilder stringBuilder = new StringBuilder();
        int spanStart = 0;
        int spanEnd = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (specialTokenList.contains("" + c)){
                if (state == TokenizerStates.text || state == TokenizerStates.trialingSpace) {
                    String rawString = stringBuilder.toString();
                    tokenList.add(new SyntaxToken(null, rawString, spanStart, spanEnd, spanStart, i, SyntaxKind.Undetermined, false));
                    stringBuilder = new StringBuilder();
                    state = TokenizerStates.specialToken;
                    spanStart = i;
                }
                if (state == TokenizerStates.specialToken)  {
                    if (specialTokenList.contains(stringBuilder.toString() + c)) {
                        stringBuilder.append(c);
                        spanEnd = i + 1;
                    }
                    else {
                        String rawString = stringBuilder.toString();
                        tokenList.add(new SyntaxToken(null, rawString, spanStart, spanEnd, spanStart, i, SyntaxKind.Undetermined, false));
                        stringBuilder = new StringBuilder();
                        state = TokenizerStates.specialToken;
                        spanStart = i;
                        stringBuilder.append(c);
                        spanEnd = i + 1;
                    }
                }
                continue;
            }

            if(state == TokenizerStates.specialToken && !Character.isWhitespace(c) && !specialTokenList.contains("" + c)){
                String rawString = stringBuilder.toString();
                tokenList.add(new SyntaxToken(null, rawString, spanStart, spanEnd, spanStart, i, SyntaxKind.Undetermined, false));
                stringBuilder = new StringBuilder();
                state = TokenizerStates.text;
                spanStart = i;
                stringBuilder.append(c);
                spanEnd = i + 1;
                continue;
            }

            if (state == TokenizerStates.leadingSpace && !Character.isWhitespace(c) && !specialTokenList.contains("" + c)) {
                stringBuilder.append(c);
                state = TokenizerStates.text;
                spanStart = i;
                spanEnd = i + 1;
                continue;
            }
            if (state == TokenizerStates.text && !Character.isWhitespace(c) && !specialTokenList.contains("" + c)) {
                stringBuilder.append(c);
                spanEnd = i + 1;
                continue;
            }
            if ((state == TokenizerStates.text || state == TokenizerStates.specialToken) && Character.isWhitespace(c)) {
                state = TokenizerStates.trialingSpace;
                continue;
            }
            if (state == TokenizerStates.trialingSpace && !Character.isWhitespace(c) && !specialTokenList.contains("" + c)) {
                String rawString = stringBuilder.toString();
                tokenList.add(new SyntaxToken(null, rawString, spanStart, spanEnd, spanStart, i, SyntaxKind.Undetermined, false));
                stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                state = TokenizerStates.text;
                spanStart = i;
                spanEnd = i + 1;
                continue;
            }
        }
        String finalString = stringBuilder.toString();
        if (!finalString.equals("")) {
            tokenList.add(new SyntaxToken(null, finalString, spanStart, spanEnd, spanStart, text.length(), SyntaxKind.Undetermined, false));
            spanEnd=text.length();
        }
        return tokenList;
    }
}
