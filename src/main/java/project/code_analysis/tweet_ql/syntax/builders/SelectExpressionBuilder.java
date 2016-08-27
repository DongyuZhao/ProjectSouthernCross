package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.SelectExpressionSyntax;

/**
 * ProjectSouthernCross
 * <p>
 * SELECTd by Dy.Zhao on 2016/8/15.
 */
public class SelectExpressionBuilder extends AbstractSyntaxNodeBuilder<SelectExpressionSyntax> {
    private AttributeListBuilder attributeListBuilder = new AttributeListBuilder();
    private StreamListBuilder sourceListBuilder = new StreamListBuilder();
    private ParseStates currentState = ParseStates.ROOT;

    public SelectExpressionSyntax build() {
        this.root = new SelectExpressionSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case SELECT_KEYWORD:
                            this.currentState = ParseStates.AFTER_SELECT;
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.attributeListBuilder.append(token);
                            break;
                        case STAR_TOKEN:
                            this.currentState = ParseStates.AFTER_STAR;
                            this.attributeListBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_STAR:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case FROM_KEYWORD:
                            this.currentState = ParseStates.AFTER_FROM;
                            this.root.addChildNode(this.attributeListBuilder.build());
                            this.sourceListBuilder.clear();
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = ParseStates.AFTER_COMMA;
                            this.attributeListBuilder.append(token);
                            break;
                        case FROM_KEYWORD:
                            this.currentState = ParseStates.AFTER_FROM;
                            this.root.addChildNode(this.attributeListBuilder.build());
                            this.sourceListBuilder.clear();
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_COMMA:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.attributeListBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_FROM:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.currentState = ParseStates.ROOT;
                            //this.sourceListBuilder.append(token);
                            this.root.addChildNode(this.sourceListBuilder.build());
                            this.root.addChildToken(token);
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
        AFTER_SELECT,
        AFTER_IDENTIFIER,
        AFTER_STAR,
        AFTER_COMMA,
        AFTER_FROM,
    }
}
