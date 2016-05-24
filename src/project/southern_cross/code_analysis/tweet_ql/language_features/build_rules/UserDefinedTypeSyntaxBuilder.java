package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;
import project.southern_cross.code_analysis.tweet_ql.language_features.UserDefinedTypeSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class UserDefinedTypeSyntaxBuilder extends SyntaxNodeBuilder<UserDefinedTypeSyntax> {
    private enum BuilderStates {
        Default,
        LeftBracket,
        RightBracket,
        Comma,
        As,
        ParsedDefault
    }

    private class UserDefinedTypeSyntaxBuildRule extends SyntaxNodeBuildRule<UserDefinedTypeSyntax> {
        private BuilderStates currentState = BuilderStates.Default;

        @Override
        public void build() {
            InstanceAttributeSyntaxBuilder instanceAttributeSyntaxBuilder = new InstanceAttributeSyntaxBuilder(
                    this.buildContext.getNode(),
                    this.buildContext.getSpan().start(),
                    this.buildContext.getFullSpan().start()
            );
            for (int i = 0; i < this.getChildTokens().size(); i++) {
                SyntaxToken token = this.getChildTokens().get(i);
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (token.kind() == TweetQlSyntaxKind.Comma) {
                    instanceAttributeSyntaxBuilder.appendChildToken(token);
                    this.buildContext.getNode().addChildNode(instanceAttributeSyntaxBuilder.toSyntaxNode());
                    this.currentState = BuilderStates.Comma;
                    continue;
                }
                if (this.currentState == BuilderStates.Comma) {
                    instanceAttributeSyntaxBuilder = new InstanceAttributeSyntaxBuilder(
                            this.buildContext.getNode(),
                            token.span().start(),
                            token.fullSpan().start()
                    );
                    i -= 1;
                    this.currentState = BuilderStates.Default;
                    continue;
                }
                if (this.currentState == BuilderStates.Default) {
                    if (token.kind() == TweetQlSyntaxKind.LeftBracket) {
                        this.currentState = BuilderStates.LeftBracket;
                        continue;
                    }
                    if (token.kind() == TweetQlSyntaxKind.RightBracket) {
                        token.setUnexpected(true);
                        token.setWithError(true);
                        this.buildContext.getNode().addChildToken(token);
                        continue;
                    }
                    if (token.kind() == TweetQlSyntaxKind.AS) {
                        this.currentState = BuilderStates.As;
                        continue;
                    }
                    instanceAttributeSyntaxBuilder.appendChildToken(token);
                }
                if (this.currentState == BuilderStates.LeftBracket) {
                    if (token.kind() == TweetQlSyntaxKind.RightBracket) {
                        this.currentState = BuilderStates.RightBracket;
                        this.buildContext.getNode().addChildNode(instanceAttributeSyntaxBuilder.toSyntaxNode());
                        continue;
                    }
                }
                if (this.currentState == BuilderStates.RightBracket) {
                    if (token.kind() == TweetQlSyntaxKind.AS) {
                        this.currentState = BuilderStates.As;
                        continue;
                    }
                    token.setUnexpected(true);
                    token.setWithError(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.As) {
                    if (token.kind() == TweetQlSyntaxKind.UnDetermined) {
                        this.buildContext.getNode().setType(token.getRawString());
                        this.currentState = BuilderStates.ParsedDefault;
                        continue;
                    }
                    token.setUnexpected(true);
                    token.setWithError(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
            }
            if (this.currentState == BuilderStates.LeftBracket) {
                this.buildContext.getNode().addChildToken(
                        new SyntaxToken(
                                this.buildContext.getNode(),
                                "",
                                this.buildContext.getSpan().start(),
                                0,
                                this.buildContext.getFullSpan().start(),
                                0,
                                TweetQlSyntaxKind.LeftBracket,
                                true,
                                false,
                                true
                        )
                );
                this.buildContext.getNode().setWithError(true);
            }
            if (this.currentState == BuilderStates.Default) {
                this.buildContext.getNode().addChildNode(instanceAttributeSyntaxBuilder.toSyntaxNode());
            }
        }
    }

    public UserDefinedTypeSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
    }
}
