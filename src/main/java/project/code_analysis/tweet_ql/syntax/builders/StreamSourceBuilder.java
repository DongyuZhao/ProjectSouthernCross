package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.structure_expressions.StreamSource;

/**
 * An implement of AbstractSyntaxNodeBuilder to build StreamSource node
 */
public class StreamSourceBuilder extends AbstractSyntaxNodeBuilder<StreamSource> {
    private EvaluableExpressionBuilder filterBuilder;
    private State currentState = State.ROOT;

    @Override
    public StreamSource build() {
        this.currentState = State.ROOT;
        this.root = new StreamSource();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case STAR_TOKEN:
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
                        case WHERE_KEYWORD:
                            this.root.addChildToken(token);
                            this.currentState = State.AFTER_WHERE;
                            this.filterBuilder = new EvaluableExpressionBuilder();
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_WHERE:
                    if (this.filterBuilder != null) {
                        this.filterBuilder.append(token);
                    }
                    break;
            }
        });
        if (this.filterBuilder != null) {
            SyntaxNode result = this.filterBuilder.build();
            this.root.addChildNode(result);
        }
        return root;
    }

    private enum State {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_WHERE,
    }
}
