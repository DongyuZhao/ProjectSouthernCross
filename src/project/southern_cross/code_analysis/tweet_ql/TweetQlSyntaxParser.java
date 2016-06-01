package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxKind;
import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import project.southern_cross.code_analysis.tweet_ql.language_features.*;
import project.southern_cross.code_analysis.tweet_ql.language_features.build_rules.CreateExpressionSyntaxBuilder;
import project.southern_cross.code_analysis.tweet_ql.language_features.build_rules.SelectExpressionSyntaxBuilder;
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

    public TweetQlSyntaxParser(String source) {
        Tokenizer tokenizer = new Tokenizer(source, TweetQlSyntaxKind.Operator.keySet());
        this.tokenList = tokenizer.tokenize();
    }

    public TweetQlSyntaxTree parse() {
        this.updateContextFreeTokens();
        this.constructSyntaxTree();
        return new TweetQlSyntaxTree(this.root);
    }

    private void updateContextFreeTokens() {
        for (SyntaxToken token : this.tokenList) {
            String rawString = token.getRawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString) || TweetQlLanguageFeatures.SyntaxFacts.isOperator(rawString)) {
                token.setKind(TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString));
            }
        }
    }

    private void constructSyntaxTree() {
        this.root = new SyntaxNode(null, 0, 0, 0, 0, SyntaxKind.Root, false, false, false);
        this.currentParent = this.root;
        this.currentState = ParserStates.Root;
//        CreateExpressionSyntaxBuilder createExpressionSyntaxBuilder = new CreateExpressionSyntaxBuilder(this.root, 0, 0);
        CreateExpressionSyntaxBuilder createExpressionSyntaxBuilder = null;
        SelectExpressionSyntaxBuilder selectExpressionSyntaxBuilder = null;
        for (int i = 0; i < this.tokenList.size(); i++) {
            SyntaxToken token = this.tokenList.get(i);
            if (this.currentState == ParserStates.Root) {
                switch (token.kind()) {
                    case TweetQlSyntaxKind.CREATE:
                    this.currentState = ParserStates.CreateExpression;
                    createExpressionSyntaxBuilder = new CreateExpressionSyntaxBuilder(this.root, token.span().start(), token.fullSpan().start());
                    break;

                    case TweetQlSyntaxKind.SELECT:
                    this.currentState = ParserStates.SelectExpression;
                    selectExpressionSyntaxBuilder = new SelectExpressionSyntaxBuilder(this.root, token.span().start(), token.fullSpan().start());
                    break;

                    default:
                        token.setUnexpected(true);
                        this.root.addChildToken(token);
                }

            }
            if (this.currentState == ParserStates.CreateExpression) {
                createExpressionSyntaxBuilder.appendChildToken(token);
                if (token.kind() == TweetQlSyntaxKind.SemiColon)
                {
                    this.currentState = ParserStates.Root;
                    this.root.addChildNode(createExpressionSyntaxBuilder.toSyntaxNode());
                    createExpressionSyntaxBuilder = null;
                }
                continue;
            }
            if (this.currentState == ParserStates.SelectExpression) {
                selectExpressionSyntaxBuilder.appendChildToken(token);
                if (token.kind() == TweetQlSyntaxKind.SemiColon)
                {
                    this.currentState = ParserStates.Root;
                    this.root.addChildNode(selectExpressionSyntaxBuilder.toSyntaxNode());
                    selectExpressionSyntaxBuilder = null;
                }
                continue;
            }
        }
        if (this.currentState != ParserStates.Root) {
            if (createExpressionSyntaxBuilder != null) {
                this.root.addChildNode(createExpressionSyntaxBuilder.toSyntaxNode());
            }
            if (selectExpressionSyntaxBuilder != null) {
                this.root.addChildNode(selectExpressionSyntaxBuilder.toSyntaxNode());
            }
        }
        //this.root.addChildNode(createExpressionSyntaxBuilder.toSyntaxNode());
    }
}
