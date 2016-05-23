package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/22 0022.
 */
public class TweetQlSyntaxParser {
    private ArrayList<SyntaxToken> tokenList;
    private static ArrayList<String> SpecialTokens = TweetQlLanguageFeatures.SyntaxFacts.getSpecialTokenList();

    public TweetQlSyntaxParser(String source) {
        Tokenizer tokenizer = new Tokenizer(source, TweetQlSyntaxParser.SpecialTokens);
        this.tokenList = tokenizer.tokenize();
    }

    public TweetQlSyntaxTree parse() {
        updateContextFreeTokens();
        throw new NotImplementedException();
    }

    private void updateContextFreeTokens() {
        for (SyntaxToken token : tokenList) {
            String rawString = token.rawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString)) {
                token.setKind(TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString));
            }
        }
    }

    
}
