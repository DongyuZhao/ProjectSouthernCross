package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.SelectExpressionSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * SELECTd by Dy.Zhao on 2016/8/15.
 */
public class SelectExpressionBuilder {
    private SelectExpressionSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private AttributeListBuilder attributeListBuilder = new AttributeListBuilder();
    private StreamListBuilder sourceListBuilder = new StreamListBuilder();
    private ParseStates currentState = ParseStates.ROOT;

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public SelectExpressionSyntax build() {
        this.root = new SelectExpressionSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case SELECT_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_SELECT;
                            this.root.addChildToken(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_SELECT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.attributeListBuilder.append(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_IDENTIFIER:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = ParseStates.AFTER_COMMA;
                            this.attributeListBuilder.append(token);
                            return;
                        case FROM_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_FROM;
                            this.root.addChildNode(this.attributeListBuilder.build());
                            this.sourceListBuilder.clear();
                            this.sourceListBuilder.append(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_COMMA:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.attributeListBuilder.append(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_FROM:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case SEMICOLON_TOKEN:
                            this.currentState = ParseStates.ROOT;
                            this.sourceListBuilder.append(token);
                            this.root.addChildNode(this.sourceListBuilder.build());
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        });
        return this.root;
    }

    private enum ParseStates {
        ROOT,
        AFTER_SELECT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
        AFTER_FROM,
    }
}
