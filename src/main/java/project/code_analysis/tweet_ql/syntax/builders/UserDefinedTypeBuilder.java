package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.UserDefinedTypeSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class UserDefinedTypeBuilder {
    private UserDefinedTypeSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private StreamFilterExpressionBuilder filterBuilder = new StreamFilterExpressionBuilder();
    private ParseStates currentState = ParseStates.ROOT;

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public UserDefinedTypeSyntax build() {
        this.root = new UserDefinedTypeSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.root.addChildToken(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_IDENTIFIER:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case WHERE_KEYWORD_TOKEN:
                            this.currentState = ParseStates.AFTER_WHERE;
                            this.filterBuilder.append(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_WHERE:
                    this.filterBuilder.append(token);
                    return;

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
