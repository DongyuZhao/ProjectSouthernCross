package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.*;
import project.southern_cross.code_analysis.tweet_ql.language_features.SelectExpressionSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.SystemObjectSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class SystemObjectSyntaxBuilder extends SyntaxNodeBuilder<SystemObjectSyntax> {
    private enum BuilderStates {
        Default,
        Parenthesis,
        Bracket,
        ParsedBracket,
        ParsedParenthesis,
        ParsedDefault
    }

    private class SystemObjectSyntaxBuildRule extends SyntaxNodeBuildRule<SystemObjectSyntax> {
        private BuilderStates currentState = BuilderStates.Default;

        @Override
        public void build() {
            for (SyntaxToken token: this.getChildTokens()) {
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (token.kind() == TweetQlSyntaxKind.LeftParenthesis) {
                    this.currentState = BuilderStates.Parenthesis;
                    continue;
                }
                if (token.kind() == TweetQlSyntaxKind.LeftBracket) {
                    this.currentState = BuilderStates.Bracket;
                    continue;
                }
                if (token.kind() == TweetQlSyntaxKind.UnDetermined) {
                    if (this.currentState == BuilderStates.Bracket) {
                        token.setKind(TweetQlSyntaxKind.UserDefinedType);
                        this.buildContext.getNode().addChildToken(token);
                        this.buildContext.getNode().setType(token.getRawString(), token.getRawString());
                        this.currentState = BuilderStates.ParsedBracket;
                        continue;
                    }
                    if (this.currentState == BuilderStates.Parenthesis) {
                        token.setKind(TweetQlSyntaxKind.UserDefinedType);
                        this.buildContext.getNode().addChildToken(token);
                        this.buildContext.getNode().setType(token.getRawString());
                        this.currentState = BuilderStates.ParsedParenthesis;
                        continue;
                    }
                }
                if (this.currentState == BuilderStates.ParsedBracket) {
                    if (token.kind() == TweetQlSyntaxKind.RightBracket) {
                        this.currentState = BuilderStates.ParsedDefault;
                        continue;
                    } else {
                        this.currentState = BuilderStates.ParsedDefault;
                        this.buildContext.getNode().addChildToken(
                                new SyntaxToken(
                                        this.buildContext.getNode(),
                                        "",
                                        0,
                                        0,
                                        0,
                                        0,
                                        TweetQlSyntaxKind.RightBracket,
                                        true,
                                        false,
                                        true
                                )
                        );
                        token.setUnexpected(true);
                        this.buildContext.getNode().addChildToken(token);
                        this.buildContext.getNode().setWithError(true);
                    }
                }
                if (this.currentState == BuilderStates.ParsedParenthesis) {
                    if (token.kind() == TweetQlSyntaxKind.RightParenthesis) {
                        this.currentState = BuilderStates.ParsedDefault;
                        continue;
                    } else {
                        this.currentState = BuilderStates.ParsedDefault;
                        this.buildContext.getNode().addChildToken(
                                new SyntaxToken(
                                        this.buildContext.getNode(),
                                        "",
                                        0,
                                        0,
                                        0,
                                        0,
                                        TweetQlSyntaxKind.RightParenthesis,
                                        true,
                                        false,
                                        true
                                )
                        );
                        token.setUnexpected(true);
                        this.buildContext.getNode().addChildToken(token);
                        this.buildContext.getNode().setWithError(true);
                    }
                }
                if (currentState == BuilderStates.ParsedDefault) {
                    token.setUnexpected(true);
                    this.buildContext.getNode().setWithError(true);
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
            }
            if (this.currentState != BuilderStates.ParsedDefault) {
                if (this.getChildTokens().size() != 0) {
                    int kind = TweetQlSyntaxKind.UnDetermined;
                    if (this.getChildTokens().get(0).kind() == TweetQlSyntaxKind.LeftBracket) {
                        kind = TweetQlSyntaxKind.RightBracket;
                    }
                    if (this.getChildTokens().get(0).kind() == TweetQlSyntaxKind.LeftParenthesis) {
                        kind = TweetQlSyntaxKind.RightParenthesis;
                    }
                    this.buildContext.getNode().addChildToken(
                            new SyntaxToken(
                                    this.buildContext.getNode(),
                                    "",
                                    0,
                                    0,
                                    0,
                                    0,
                                    kind,
                                    true,
                                    false,
                                    true
                            )
                    );
                    this.buildContext.getNode().setWithError(true);
                }
            }
        }
    }

    public SystemObjectSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.node = new SystemObjectSyntax(parent, "", startSpan, 0, startFullSpan, 0, TweetQlSyntaxKind.SystemObject, false, false, false);
        this.specifiedRule(new SystemObjectSyntaxBuildRule());
        this.rule.setContext(this);
    }
}
