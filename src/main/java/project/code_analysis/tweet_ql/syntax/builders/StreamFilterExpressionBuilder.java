package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxFacts;
import project.code_analysis.tweet_ql.syntax.nodes.StreamFilterExpressionSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StreamFilterExpressionBuilder {
    private StreamFilterExpressionSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private ParseStates currentState = ParseStates.ROOT;

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public StreamFilterExpressionSyntax build() {
        this.root = new StreamFilterExpressionSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case WHERE_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_WHERE;
                            return;
                        default:
                            return;
                    }
                case AFTER_WHERE:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_FIRST_IN_BINARY;
                            this.root.addChildToken(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_FIRST_IN_BINARY:
                    if (TweetQlSyntaxFacts.getInstance().isBinaryOperator(token.getRawString())) {
                        this.currentState = ParseStates.AFTER_OPERATOR_IN_BINARY;
                        this.root.addChildToken(token);
                        return;
                    }
                case AFTER_OPERATOR_IN_BINARY:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_SECOND_IN_BINARY;
                            this.root.addChildToken(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_SECOND_IN_BINARY:
                    return;
                default:
                    return;
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
