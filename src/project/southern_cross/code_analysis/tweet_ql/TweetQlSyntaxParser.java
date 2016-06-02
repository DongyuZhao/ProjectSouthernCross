package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxKind;
import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import project.southern_cross.code_analysis.tweet_ql.language_features.*;
import project.southern_cross.code_analysis.tweet_ql.language_features.build_rules.CreateExpressionSyntaxBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/22 0022.
 */
public class TweetQlSyntaxParser {
    private enum ParserStates {
        Root,
        CreateExpression,
        SelectExpression,
        FromExpression

    }
    private ArrayList<SyntaxToken> tokenList;
    private SyntaxNode root;
    private ParserStates currentState = ParserStates.Root;
    private SyntaxNode currentParent;


    /**
     *  Split a string into several token
     * @param source
     * Return an arraylist contains all token
     */

    public TweetQlSyntaxParser(String source) {
        Tokenizer tokenizer = new Tokenizer(source, TweetQlSyntaxKind.Operator.keySet());
        this.tokenList = tokenizer.tokenize();
    }

    /**
     * call updateContextFreeTokens() and constructSyntaxTree()
     * @return
     * return a SyntaxTree with this root node.
     */
    public TweetQlSyntaxTree parse() {
        this.updateContextFreeTokens();
        this.constructSyntaxTree();
        return new TweetQlSyntaxTree(this.root);
    }

    /**
     * traversing all token in the tokenList
     * if this token is Keyword or reserve word, change its SyntaxKind to corresponding value.
     */
    private void updateContextFreeTokens() {
        for (SyntaxToken token : this.tokenList) {
            String rawString = token.getRawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString) || TweetQlLanguageFeatures.SyntaxFacts.isOperator(rawString)) {
                token.setKind(TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString));
            }
        }
    }

    /**
     * used to generate a syntaxTree.
     * now createExpression only.
     *
     */
    private void constructSyntaxTree() {
        this.root = new SyntaxNode(null, 0, 0, 0, 0, SyntaxKind.Root, false, false, false);
        this.currentParent = this.root;
        this.currentState = ParserStates.Root;
        CreateExpressionSyntaxBuilder createExpressionSyntaxBuilder = new CreateExpressionSyntaxBuilder(this.root, 0, 0);
        for (int i = 0; i < this.tokenList.size(); i++) {
            SyntaxToken token = this.tokenList.get(i);
            createExpressionSyntaxBuilder.appendChildToken(token);
        }
        this.root.addChildNode(createExpressionSyntaxBuilder.toSyntaxNode());
    }
}
