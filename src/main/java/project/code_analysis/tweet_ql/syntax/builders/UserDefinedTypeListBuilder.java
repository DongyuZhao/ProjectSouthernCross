package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.VariableListSyntax;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/23.
 */
public class UserDefinedTypeListBuilder<T extends VariableListSyntax> extends AbstractSyntaxNodeBuilder<T> {
    private UserDefinedTypeBuilder streamBuilder = new UserDefinedTypeBuilder();
    private ParseStates currentState = ParseStates.ROOT;

    UserDefinedTypeListBuilder(T root) {
        this.root = root;
    }

    public T build() {
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    this.streamBuilder.append(token);
                    this.currentState = ParseStates.AFTER_IDENTIFIER;
                    break;
                case AFTER_IDENTIFIER:
                    switch ((TweetQlTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.root.addChildNode(this.streamBuilder.build());
                            this.root.addChildToken(token);
                            this.streamBuilder = new UserDefinedTypeBuilder();
                            this.currentState = ParseStates.AFTER_COMMA;
                            break;
                        default:
                            this.streamBuilder.append(token);
                            break;
                    }
                    break;
                case AFTER_COMMA:
                    this.streamBuilder.append(token);
                    this.currentState = ParseStates.AFTER_IDENTIFIER;
                    break;
                default:
                    break;
            }
        });
        this.root.addChildNode(this.streamBuilder.build());
        return this.root;
    }
//
//    private void processIdentifiers(SyntaxToken token) {
//        switch ((TweetQlTokenKind) token.getKind()) {
//            case IDENTIFIER_TOKEN:
//            case STAR_TOKEN:
//                this.currentState = ParseStates.AFTER_IDENTIFIER;
//                this.streamBuilderList.add(new UserDefinedTypeBuilder());
//                this.currentBuilderPointer += 1;
//                this.streamBuilderList.get(this.currentBuilderPointer).append(token);
//                break;
//            default:
//                break;
//        }
//    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
    }
}
