package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.UserDefinedTypeListSyntax;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/8/23.
 */
public class UserDefinedTypeListBuilder {
    private UserDefinedTypeListSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private ArrayList<UserDefinedTypeBuilder> streamBuilderList = new ArrayList<>();
    private int currentBuilderPointer = -1;
    private ParseStates currentState = ParseStates.ROOT;

    public UserDefinedTypeListBuilder(UserDefinedTypeListSyntax root) {
        this.root = root;
    }

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public UserDefinedTypeListSyntax build() {
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                        case STAR_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.streamBuilderList.add(new UserDefinedTypeBuilder());
                            this.currentBuilderPointer += 1;
                            this.streamBuilderList.get(this.currentBuilderPointer).append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                case AFTER_IDENTIFIER:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = ParseStates.AFTER_COMMA;
                            break;
                        default:
                            this.streamBuilderList.get(this.currentBuilderPointer).append(token);
                            break;
                    }
                    break;
                case AFTER_COMMA:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                        case STAR_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.streamBuilderList.add(new UserDefinedTypeBuilder());
                            this.currentBuilderPointer += 1;
                            this.streamBuilderList.get(this.currentBuilderPointer).append(token);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        });
        this.streamBuilderList.forEach(builder -> this.root.addChildNode(builder.build()));
        return this.root;
    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
    }
}
