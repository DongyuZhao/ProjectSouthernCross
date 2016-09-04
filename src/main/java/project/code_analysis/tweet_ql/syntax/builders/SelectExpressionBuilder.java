package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.SelectExpression;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/4.
 */
public class SelectExpressionBuilder extends AbstractSyntaxNodeBuilder<SelectExpression> {
    private AttributeListBuilder attributeListBuilder;
    private StreamSourceListBuilder streamSourceListBuilder;
    private State currentState = State.ROOT;

    @Override
    public SelectExpression build() {
        this.currentState = State.ROOT;
        this.root = new SelectExpression();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case SELECT_KEYWORD:
                            this.currentState = State.AFTER_SELECT;
                            this.root.addChildToken(token);
                            this.attributeListBuilder = new AttributeListBuilder();
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_SELECT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case FROM_KEYWORD:
                            this.currentState = State.AFTER_FROM;
                            if (this.attributeListBuilder != null) {
                                this.root.addChildNode(this.attributeListBuilder.build());
                            }
                            this.root.addChildToken(token);
                            this.streamSourceListBuilder = new StreamSourceListBuilder();
                            break;
                        default:
                            if (this.attributeListBuilder != null) {
                                this.attributeListBuilder.append(token);
                            }
                            break;
                    }
                    break;
                case AFTER_FROM:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            if (this.streamSourceListBuilder != null) {
                                this.root.addChildNode(this.streamSourceListBuilder.build());
                            }
                            this.root.addChildToken(token);
                            this.streamSourceListBuilder = new StreamSourceListBuilder();
                            break;
                        case SEMICOLON_TOKEN:
                            if (this.streamSourceListBuilder != null) {
                                this.root.addChildNode(this.streamSourceListBuilder.build());
                            }
                            this.root.addChildToken(token);
                            break;
                        default:
                            if (this.streamSourceListBuilder != null) {
                                this.streamSourceListBuilder.append(token);
                            }
                            break;
                    }
                    break;
            }
        });
        return root;
    }

    private enum State {
        ROOT,
        AFTER_SELECT,
        AFTER_FROM,
    }
}
