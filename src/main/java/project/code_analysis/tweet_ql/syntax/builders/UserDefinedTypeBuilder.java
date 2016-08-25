package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.VariableSyntax;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class UserDefinedTypeBuilder extends AbstractSyntaxNodeBuilder<VariableSyntax> {
    private StreamFilterExpressionBuilder filterBuilder = new StreamFilterExpressionBuilder();
    private ParseStates currentState = ParseStates.ROOT;

    public VariableSyntax build() {
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                        case STAR_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.root = new VariableSyntax("stream", token.getRawString());
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case WHERE_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_WHERE;
                            this.filterBuilder.append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_WHERE:
                    this.filterBuilder.append(token);
                    break;

            }
        });
        this.root.addChildNode(this.filterBuilder.build());
        return this.root;
    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_WHERE,
    }
}
