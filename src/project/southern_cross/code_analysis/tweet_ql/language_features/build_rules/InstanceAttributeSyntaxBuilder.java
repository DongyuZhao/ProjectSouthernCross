package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.*;
import project.southern_cross.code_analysis.tweet_ql.language_features.InstanceAttributeSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class InstanceAttributeSyntaxBuilder extends SyntaxNodeBuilder<InstanceAttributeSyntax> {
    private enum BuilderStates {
        Default,
        AttributeName,
        As,
        DisplayName,
        ParsedDefault,
        Comma
    }

    private class InstanceAtrributeSyntaxBuildRule extends SyntaxNodeBuildRule<InstanceAttributeSyntax> {
        private BuilderStates currentState = BuilderStates.Default;
        @Override
        public void build() {
            String attributeName = "";
            String displayName = "";
            for (SyntaxToken token: this.getChildTokens()) {
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.Default) {
                    if (token.kind() == TweetQlSyntaxKind.UnDetermined) {
                        token.setKind(TweetQlSyntaxKind.UserDefinedType);
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.AttributeName;
                        attributeName = token.getRawString();
                        this.buildContext.getNode().setType(attributeName);
                        continue;
                    }
                    this.buildContext.getNode().addChildToken(
                            new SyntaxToken(this.buildContext.getNode(),
                                    "",
                                    this.buildContext.getSpan().start(),
                                    0,
                                    this.buildContext.getFullSpan().start(),
                                    0,
                                    TweetQlSyntaxKind.UserDefinedType,
                                    true,
                                    false,
                                    true
                            )
                    );
                    this.currentState = BuilderStates.AttributeName;
                    token.setUnexpected(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.AttributeName) {
                    if (token.kind() == TweetQlSyntaxKind.AS) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.As;
                        continue;
                    }
                    if (token.kind() == TweetQlSyntaxKind.Comma) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState =BuilderStates.ParsedDefault;
                        continue;
                    }
                    token.setUnexpected(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.As) {
                    if (token.kind() == TweetQlSyntaxKind.UnDetermined) {
                        displayName = token.getRawString();
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.DisplayName;
                        this.buildContext.getNode().setType(attributeName, displayName);
                        continue;
                    }
                    token.setUnexpected(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.ParsedDefault) {
                    token.setUnexpected(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.DisplayName) {
                    if (token.kind() == TweetQlSyntaxKind.Comma) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.ParsedDefault;
                        continue;
                    }
                    token.setUnexpected(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
            }
        }
    }

    public InstanceAttributeSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.node = new InstanceAttributeSyntax(parent, "", startSpan, 0, startFullSpan, 0, TweetQlSyntaxKind.InstanceAttribute, false, false, false);
        this.specifiedRule(new InstanceAtrributeSyntaxBuildRule());
        this.rule.setContext(this);
    }
}
