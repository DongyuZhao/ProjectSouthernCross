package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.syntax.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.tokens.SelectKeywordToken;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class CompileUnitBuilder {
    private CompilationUnitSyntax root = new CompilationUnitSyntax();
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    private enum BuildStates {
        IN_CREATE_EXPRESSION,
        IN_SELECT_EXPRESSION,
        ROOT,
    }

    private BuildStates currentState = BuildStates.ROOT;

    private CreateExpressionBuilder createExpressionBuilder = new CreateExpressionBuilder();

    private SelectExpressionBuilder selectExpressionBuilder = new SelectExpressionBuilder();

    public CompilationUnitSyntax build() {
        this.tokenList.forEach(token -> {
            if (this.currentState == BuildStates.ROOT) {
                if (token.getKind() == TweetQlSyntaxTokenKind.CREATE_KEYWORD_TOKEN) {
                    this.currentState = BuildStates.IN_CREATE_EXPRESSION;
                    this.createExpressionBuilder.clear();
                    this.createExpressionBuilder.append(token);
                    return;
                }

                if (token.getKind() == TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN) {
                    this.currentState = BuildStates.IN_SELECT_EXPRESSION;
                    this.selectExpressionBuilder.clear();
                    this.selectExpressionBuilder.append(token);
                    return;
                }
            }

            if (this.currentState == BuildStates.IN_CREATE_EXPRESSION) {
                if (token.getKind() == TweetQlSyntaxTokenKind.SEMICOLON_TOKEN) {
                    this.currentState = BuildStates.ROOT;
                    this.root.addChildNode(this.createExpressionBuilder.build());
                    return;
                } else {
                    this.createExpressionBuilder.append(token);
                    return;
                }
            }

            if (this.currentState == BuildStates.IN_SELECT_EXPRESSION) {
                if (token.getKind() == TweetQlSyntaxTokenKind.SEMICOLON_TOKEN) {
                    this.currentState = BuildStates.ROOT;
                    this.root.addChildNode(this.selectExpressionBuilder.build());
                    return;
                } else {
                    this.selectExpressionBuilder.append(token);
                    return;
                }
            }
        });
        return this.root;
    }
}
