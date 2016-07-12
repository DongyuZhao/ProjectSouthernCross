package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxParser;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
public class TweetQlSyntaxParser_v2 extends SyntaxParser {
    public TweetQlSyntaxParser_v2(String source) {
        super(source, TweetQlSyntaxKind.Operator.keySet());
        this.updateContextFreeTokens();
    }

    private void updateContextFreeTokens() {
        for (SyntaxToken token : this.tokenList) {
            String rawString = token.getRawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString) || TweetQlLanguageFeatures.SyntaxFacts.isOperator(rawString)) {
                token.setKind(TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString));
            }
        }
    }

    public SyntaxNode parse() {

        return this.root;
    }
}
