package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;
import project.code_analysis.tweet_ql.syntax.nodes.StreamFilterExpressionSyntax;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StreamFilterExpressionBuilder extends AbstractSyntaxNodeBuilder<StreamFilterExpressionSyntax> {
    private ParseStates currentState = ParseStates.ROOT;

    public StreamFilterExpressionSyntax build() {
        this.root = new StreamFilterExpressionSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case WHERE_KEYWORD:
                            this.currentState = ParseStates.AFTER_WHERE;
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_WHERE:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_FIRST_IN_BINARY;
                            this.root.addChildToken(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_FIRST_IN_BINARY:
                    if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getRawString())) {
                        this.currentState = ParseStates.AFTER_OPERATOR_IN_BINARY;
                        this.root.addChildToken(token);
                    }
                    break;
                case AFTER_OPERATOR_IN_BINARY:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_SECOND_IN_BINARY;
                            this.root.addChildToken(token);
                            break;
                        default:
                            if (TweetQlSyntaxFacts.getInstance().isLiteralString(token.getRawString()) || TweetQlSyntaxFacts.getInstance().isDigit(token.getRawString())) {
                                this.root.addChildToken(token);
                                this.currentState = ParseStates.AFTER_SECOND_IN_BINARY;
                            }
                            break;
                    }
                    break;
                case AFTER_SECOND_IN_BINARY:
                    break;
                default:
                    break;
            }
        });
        return this.root;
    }

    private enum ParseStates {
        ROOT,
        AFTER_WHERE,
        AFTER_FIRST_IN_BINARY,
        AFTER_SECOND_IN_BINARY,
        AFTER_OPERATOR_IN_BINARY,
    }
}
