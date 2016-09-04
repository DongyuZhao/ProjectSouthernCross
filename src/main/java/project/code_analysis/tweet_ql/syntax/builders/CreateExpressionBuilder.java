package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.CreateExpression;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/3.
 */
public class CreateExpressionBuilder extends AbstractSyntaxNodeBuilder<CreateExpression> {
    private UserDefinedStreamBuilder userDefinedStreamBuilder;
    private State currentState = State.ROOT;

    @Override
    public CreateExpression build() {
        this.currentState = State.ROOT;
        this.root = new CreateExpression();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case CREATE_KEYWORD:
                            this.currentState = State.AFTER_CREATE;
                            this.userDefinedStreamBuilder = new UserDefinedStreamBuilder();
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_CREATE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            if (this.userDefinedStreamBuilder != null) {
                                this.root.addChildNode(this.userDefinedStreamBuilder.build());
                            }
                            this.root.addChildToken(token);
                            this.userDefinedStreamBuilder = new UserDefinedStreamBuilder();
                            break;
                        case SEMICOLON_TOKEN:
                            if (this.userDefinedStreamBuilder != null) {
                                this.root.addChildNode(this.userDefinedStreamBuilder.build());
                            }
                            this.root.addChildToken(token);
                            break;
                        default:
                            if (this.userDefinedStreamBuilder != null) {
                                this.userDefinedStreamBuilder.append(token);
                            }
                            break;
                    }
                    break;
            }
        });
        return this.root;
    }

    private enum State {
        ROOT,
        AFTER_CREATE,
    }
}
