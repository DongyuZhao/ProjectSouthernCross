package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.structure_expressions.UserDefinedStream;

/**
 * An implement of AbstractSyntaxNodeBuilder to build UserDefinedStream node
 */
public class UserDefinedStreamBuilder extends AbstractSyntaxNodeBuilder<UserDefinedStream> {
    private StreamSourceBuilder streamSourceBuilder;
    private State currentState = State.ROOT;

    @Override
    public UserDefinedStream build() {
        this.currentState = State.ROOT;
        this.root = new UserDefinedStream();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.root.addChildToken(token);
                            this.currentState = State.AFTER_IDENTIFIER;
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case FROM_KEYWORD:
                            this.root.addChildToken(token);
                            this.streamSourceBuilder = new StreamSourceBuilder();
                            this.currentState = State.AFTER_FROM;
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_FROM:
                    if (this.streamSourceBuilder != null) {
                        this.streamSourceBuilder.append(token);
                    }
                    break;
            }
        });
        this.root.addChildNode(this.streamSourceBuilder.build());
        return this.root;
    }

    private enum State {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_FROM,
    }
}
