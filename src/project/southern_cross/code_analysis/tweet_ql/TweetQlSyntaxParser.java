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
        for (int i = 0; i < tokenList.size(); i++) {
            SyntaxToken token = tokenList.get(i);
            String rawString = token.rawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString)) {
                tokenList.add(i, new SyntaxToken(
                        null,
                        rawString,
                        token.span().start(),
                        token.span().end(),
                        token.fullSpan().start(),
                        token.fullSpan().end(),
                        TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString),
                        false)
                );
            }
        }
    }


}
