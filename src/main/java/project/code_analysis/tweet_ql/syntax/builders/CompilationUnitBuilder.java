package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;

/**
 * An implement of AbstractSyntaxNodeBuilder to build CompilationUnit node
 */
public class CompilationUnitBuilder extends AbstractSyntaxNodeBuilder<CompilationUnitSyntax> {
    private State currentState = State.ROOT;
    private CreateExpressionBuilder createExpressionBuilder;
    private SelectExpressionBuilder selectExpressionBuilder;

    @Override
    public CompilationUnitSyntax build() {
        this.currentState = State.ROOT;
        this.root = new CompilationUnitSyntax(TweetQlSyntaxFacts.getInstance().getLanguage());
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CREATE_KEYWORD:
                            this.createExpressionBuilder = new CreateExpressionBuilder();
                            this.currentState = State.IN_CREATE_EXPRESSION;
                            this.createExpressionBuilder.clear();
                            this.createExpressionBuilder.append(token);
                            break;
                        case SELECT_KEYWORD:
                            this.selectExpressionBuilder = new SelectExpressionBuilder();
                            this.currentState = State.IN_SELECT_EXPRESSION;
                            this.selectExpressionBuilder.clear();
                            this.selectExpressionBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case IN_CREATE_EXPRESSION:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.createExpressionBuilder.append(token);
                            this.currentState = State.ROOT;
                            this.root.addChildNode(this.createExpressionBuilder.build());
                            this.createExpressionBuilder = null;
                            break;
                        default:
                            this.createExpressionBuilder.append(token);
                            break;
                    }
                    break;
                case IN_SELECT_EXPRESSION:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.selectExpressionBuilder.append(token);
                            this.currentState = State.ROOT;
                            this.root.addChildNode(this.selectExpressionBuilder.build());
                            this.selectExpressionBuilder = null;
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

    private enum State {
        IN_CREATE_EXPRESSION,
        IN_SELECT_EXPRESSION,
        ROOT,
    }
}
