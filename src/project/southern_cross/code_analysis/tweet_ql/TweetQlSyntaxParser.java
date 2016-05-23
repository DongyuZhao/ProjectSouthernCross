package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/22 0022.
 */
public class TweetQlSyntaxParser {
    private ArrayList<SyntaxToken> tokenList;
    private TweetQlSyntaxTree root;

    public TweetQlSyntaxParser(String source) {
        Tokenizer tokenizer = new Tokenizer(source, TweetQlSyntaxKind.Operator.keySet());
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

    private void ConstructSyntaxTree(String source) {
        this.root = new TweetQlSyntaxTree();
        
    }
}
