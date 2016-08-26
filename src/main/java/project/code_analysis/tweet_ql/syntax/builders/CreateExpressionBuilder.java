package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.CreateExpressionSyntax;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class CreateExpressionBuilder extends AbstractSyntaxNodeBuilder<CreateExpressionSyntax> {
    private StreamListBuilder targetListBuilder = new StreamListBuilder();
    private StreamListBuilder sourceListBuilder = new StreamListBuilder();
    private ParseStates currentState = ParseStates.ROOT;

    public CreateExpressionSyntax build() {
        this.root = new CreateExpressionSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case CREATE_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_CREATE;
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_CREATE:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.targetListBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = ParseStates.AFTER_COMMA;
                            this.targetListBuilder.append(token);
                            break;
                        case FROM_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_FROM;
                            this.root.addChildNode(this.targetListBuilder.build());
                            this.sourceListBuilder.clear();
                            this.sourceListBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_COMMA:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.targetListBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_FROM:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.currentState = ParseStates.ROOT;
                            this.sourceListBuilder.append(token);
                            this.root.addChildNode(this.sourceListBuilder.build());
                            break;
                        default:
                            this.sourceListBuilder.append(token);
                            break;
                    }
                    break;
                default:
                    break;
            }
        });
        return this.root;
    }

    private enum ParseStates {
        ROOT,
        AFTER_CREATE,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
        AFTER_FROM,
    }
}
