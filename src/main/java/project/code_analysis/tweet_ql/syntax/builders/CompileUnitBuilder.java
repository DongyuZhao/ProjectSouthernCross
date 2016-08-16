package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.syntax.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class CompileUnitBuilder {
    private CompilationUnitSyntax root = new CompilationUnitSyntax();
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private BuildStates currentState = BuildStates.ROOT;
    private CreateExpressionBuilder createExpressionBuilder = new CreateExpressionBuilder();
    private SelectExpressionBuilder selectExpressionBuilder = new SelectExpressionBuilder();

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public CompilationUnitSyntax build() {
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case CREATE_KEYWORD_TOKEN:
                            this.currentState = BuildStates.IN_CREATE_EXPRESSION;
                            this.createExpressionBuilder.clear();
                            this.createExpressionBuilder.append(token);
                            break;
                        case SELECT_KEYWORD_TOKEN:
                            this.currentState = BuildStates.IN_SELECT_EXPRESSION;
                            this.selectExpressionBuilder.clear();
                            this.selectExpressionBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case IN_CREATE_EXPRESSION:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.selectExpressionBuilder.append(token);
                            this.currentState = BuildStates.ROOT;
                            this.root.addChildNode(this.createExpressionBuilder.build());
                            break;
                        default:
                            this.createExpressionBuilder.append(token);
                            break;
                    }
                    break;
                case IN_SELECT_EXPRESSION:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.selectExpressionBuilder.append(token);
                            this.currentState = BuildStates.ROOT;
                            this.root.addChildNode(this.selectExpressionBuilder.build());
                            break;
                        default:
                            this.selectExpressionBuilder.append(token);
                            break;
                    }
                    break;
                default:
                    break;
            }
        });
        return this.root;
    }

    private enum BuildStates {
        IN_CREATE_EXPRESSION,
        IN_SELECT_EXPRESSION,
        ROOT,
    }
}
