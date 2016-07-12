package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */

public class SyntaxParser {
    protected ArrayList<SyntaxToken> tokenList;
    protected SyntaxNode root;

    public SyntaxParser(String source, Set<String> specialTokenList) {
        if (source == null) {
            throw new IllegalArgumentException("Parameter 'Source' is null");
        }
        Tokenizer tokenizer = new Tokenizer(source, specialTokenList);
        this.tokenList = tokenizer.tokenize();
    }

    private void updateContextFreeTokens() {

    }
}
