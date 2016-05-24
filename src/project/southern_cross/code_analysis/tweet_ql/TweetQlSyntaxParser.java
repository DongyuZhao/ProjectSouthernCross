package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxKind;
import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.Tokenizer;
import project.southern_cross.code_analysis.tweet_ql.language_features.*;
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
        updateContextFreeTokens();
        throw new NotImplementedException();
    }

    private void updateContextFreeTokens() {
        for (SyntaxToken token : this.tokenList) {
            String rawString = token.getRawString();
            if (TweetQlLanguageFeatures.SyntaxFacts.isKeyword(rawString)) {
                token.setKind(TweetQlLanguageFeatures.SyntaxFacts.getSyntaxKind(rawString));
            }
        }
    }

    private void constructSyntaxTree(String source) {
        this.root = new SyntaxNode(null, 0, source.length(), 0, source.length(), SyntaxKind.Root, false, false);
        this.currentParent = this.root;
        this.currentState = ParserStates.Root;
        for (int i = 0; i < this.tokenList.size(); i++) {
            SyntaxToken token = this.tokenList.get(i);
//            if(this.currentState == ParserStates.Root) {
//                if (token.kind() == TweetQlSyntaxKind.CREATE){
//                    SyntaxNode createExpression = new CreateExpressionSyntax(
//                            currentParent,
//                            token.span().start(),
//                            token.span().end(),
//                            token.fullSpan().start(),
//                            token.fullSpan().end(),
//                            token.kind(),
//                            false);
//                    this.currentParent.addChildNode(createExpression);
//                    this.currentParent = createExpression;
//                    this.currentState=ParserStates.CreateExpression;
//                    continue;
//                }
//
//                if (token.kind() == TweetQlSyntaxKind.SELECT){
//                    SyntaxNode SelectExpression = new CreateExpressionSyntax(
//                            currentParent,
//                            token.span().start(),
//                            token.span().end(),
//                            token.fullSpan().start(),
//                            token.fullSpan().end(),
//                            token.kind(),
//                            false);
//                    this.currentParent.addChildNode(SelectExpression);
//                    this.currentParent = SelectExpression;
//                    this.currentState=ParserStates.SelectExpression;
//                    continue;
//                }
//
//            }
//
////            if(token.kind()==TweetQlSyntaxKind.UnDetermined){
////                int kind=token.kind();
////                if(currentState==ParserStates.CreateExpression){
////                    kind=TweetQlSyntaxKind.UserDefinedType;
////                }else if (currentState ==ParserStates.FromExpression){
////                    kind=TweetQlSyntaxKind.UserDefinedType;
////                }
////                SyntaxNode userDefined = new UserDefinedTypeSyntax(
////                        currentParent,
////                        token.span().start(),
////                        token.span().end(),
////                        token.fullSpan().start(),
////                        token.fullSpan().end(),
////                        kind,
////                        false);
////                this.currentParent.addChildNode(userDefined);
////                continue;
////            }
//
//
//            if (token.kind()==TweetQlSyntaxKind.FROM){
//                SyntaxNode fromExpress = new FromExpressionSyntax(
//                        currentParent,
//                        token.getRawString(),
//                        token.span().start(),
//                        token.span().end(),
//                        token.fullSpan().start(),
//                        token.fullSpan().end(),
//                        token.kind(),
//                        false );
//                this.currentParent.addChildNode(fromExpress);
//                this.currentParent = fromExpress;
//                this.currentState=ParserStates.FromExpression;
//            }
        }
    }
}
