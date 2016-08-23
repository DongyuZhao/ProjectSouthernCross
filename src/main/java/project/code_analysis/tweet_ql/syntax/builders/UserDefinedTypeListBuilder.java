package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.syntax.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.UserDefinedTypeListSyntax;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/8/23.
 */
public class UserDefinedTypeListBuilder<T extends UserDefinedTypeListSyntax> extends AbstractSyntaxNodeBuilder<T> {
    private ArrayList<UserDefinedTypeBuilder> streamBuilderList = new ArrayList<>();
    private int currentBuilderPointer = -1;
    private ParseStates currentState = ParseStates.ROOT;

    UserDefinedTypeListBuilder(T root) {
        this.root = root;
    }

    public T build() {
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    processIdentifiers(token);
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
                    processIdentifiers(token);
                    break;
                default:
                    break;
            }
        });
        this.streamBuilderList.forEach(builder -> this.root.addChildNode(builder.build()));
        return this.root;
    }

    private void processIdentifiers(SyntaxToken token) {
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
    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
    }
}
