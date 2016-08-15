package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.SelectExpressionSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class SelectExpressionBuilder {
    private SelectExpressionSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    private enum ParseStates {
        ROOT,
        AFTER_SELECT,
        AFTER_FROM,
    }

    private AttributeListBuilder attributeListBuilder = new AttributeListBuilder();

    private StreamListBuilder sourceListBuilder = new StreamListBuilder();

    private ParseStates currentStates = ParseStates.ROOT;

    public SelectExpressionSyntax build() {
        this.root = new SelectExpressionSyntax();
        this.tokenList.forEach(token -> {
            if (this.currentStates == ParseStates.ROOT) {
                if (token.getKind() == TweetQlSyntaxTokenKind.SELECT_KEYWORD_TOKEN) {
                    this.currentStates = ParseStates.AFTER_SELECT;
                    return;
                }
            }
            if (this.currentStates == ParseStates.AFTER_SELECT) {
                if (token.getKind() != TweetQlSyntaxTokenKind.FROM_KEYWORD_TOKEN) {
                    this.attributeListBuilder.append(token);
                } else {
                    this.root.addChildNode(this.attributeListBuilder.build());
                    this.currentStates = ParseStates.AFTER_FROM;
                }
                return;
            }
            if (this.currentStates == ParseStates.AFTER_FROM) {
                this.sourceListBuilder.append(token);
                if (token.getKind() == TweetQlSyntaxTokenKind.SEMICOLON_TOKEN) {
                    this.root.addChildNode(this.sourceListBuilder.build());
                    this.currentStates = ParseStates.ROOT;
                }
                return;
            }
            return;
        });
        return this.root;
    }
}
