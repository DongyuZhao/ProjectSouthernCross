package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxKind;
import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import project.southern_cross.code_analysis.tweet_ql.language_features.CreateExpressionNode;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxFacts;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/22 0022.
 */
public class TweetQlSyntaxParser {
    private enum ParserStates {
        Root,
        CreateExpression
    }
    private ArrayList<SyntaxToken> tokenList;
    private SyntaxNode root;
    private ParserStates currentState = ParserStates.Root;
    private SyntaxNode currentParent;

    public TweetQlSyntaxParser(String source) {
        Tokenizer tokenizer = new Tokenizer(source, TweetQlSyntaxKind.Operator.keySet());
        this.tokenList = tokenizer.tokenize();
    }

    public TweetQlSyntaxTree parse() {
        updateContextFreeTokens();
        throw new NotImplementedException();
    }

    private void updateContextFreeTokens() {
        for (SyntaxToken token : this.tokenList) {
            String rawString = token.rawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString)) {
                token.setKind(TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString));
            }
        }
    }

    private void ConstructSyntaxTree(String source) {
        this.root = new SyntaxNode(null, source, 0, source.length(), 0, source.length(), SyntaxKind.Root, false);
        this.currentParent = this.root;
        this.currentState = ParserStates.Root;
        for (int i = 0; i < this.tokenList.size(); i++) {
            SyntaxToken token = this.tokenList.get(i);
            if(this.currentState == ParserStates.Root) {
                if (token.kind() == TweetQlSyntaxKind.CREATE){
                    SyntaxNode createExpression = new CreateExpressionNode(
                            currentParent,
                            token.rawString(),
                            token.span().start(),
                            token.span().end(),
                            token.fullSpan().start(),
                            token.fullSpan().end(),
                            token.kind(),
                            false);
                    this.currentParent.addChildNode(createExpression);
                    this.currentParent = createExpression;
                }
                if (this.currentState == ParserStates.CreateExpression) {

                }
            }
        }
    }
}
