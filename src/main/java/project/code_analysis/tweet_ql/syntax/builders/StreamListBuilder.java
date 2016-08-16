package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.StreamListSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StreamListBuilder {
    private StreamListSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private ArrayList<UserDefinedTypeBuilder> streamBuilderList = new ArrayList<>();
    private int currentBuilderPointer = -1;
    private ParseStates currentState = ParseStates.ROOT;

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public StreamListSyntax build() {
        this.root = new StreamListSyntax();
        this.tokenList.forEach(token -> {
            switch (this.currentState) {
                case ROOT:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.streamBuilderList.add(new UserDefinedTypeBuilder());
                            this.currentBuilderPointer += 1;
                            this.streamBuilderList.get(this.currentBuilderPointer).append(token);
                            return;
                        default:
                            return;
                    }
                case AFTER_IDENTIFIER:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case COMMA_TOKEN:
                            this.currentState = ParseStates.AFTER_COMMA;
                            return;
                        default:
                            this.streamBuilderList.get(this.currentBuilderPointer).append(token);
                            return;
                    }
                case AFTER_COMMA:
                    switch ((TweetQlSyntaxTokenKind) token.getKind()) {
                        case IDENTIFIER_TOKEN:
                            this.currentState = ParseStates.AFTER_IDENTIFIER;
                            this.streamBuilderList.add(new UserDefinedTypeBuilder());
                            this.currentBuilderPointer += 1;
                            this.streamBuilderList.get(this.currentBuilderPointer).append(token);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
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
