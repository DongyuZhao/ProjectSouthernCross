package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.FromExpressionSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by donggeliu on 24/05/2016.
 */
public class FromExpressionSyntaxBuilder extends SyntaxNodeBuilder<FromExpressionSyntax> {
    private enum BuilderStates {
        Default,
        FromKeyWord,
        InstanceAttribute,
        SubExpression,
        SystemObject,
        UserDefined,
        ParsedDefault
    }

    private class FromExpressionSyntaxRule extends SyntaxNodeBuildRule<FromExpressionSyntax> {
        private BuilderStates currentState = BuilderStates.Default;

        @Override
        public void build() {
            int skip = 0;
            SystemObjectSyntaxBuilder systemObjectSyntaxBuilder = null;
            UserDefinedTypeSyntaxBuilder userDefinedTypeSyntaxBuilder = null;
            for (int i = 0; i < this.getChildTokens().size(); i++) {
                SyntaxToken token = this.getChildTokens().get(i);
                boolean missing = false;
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    skip += 1;
                    continue;
                }
                if (this.currentState == BuilderStates.Default) {
                    if (i == skip) {
                        FromKeywordBuilder fromKeywordBuilder = new FromKeywordBuilder(
                                this.buildContext.getNode(),
                                token.span().start(),
                                token.fullSpan().start()
                        );
                        if (token.kind() == TweetQlSyntaxKind.FROM) {
                            fromKeywordBuilder.appendChildToken(token);
                        } else {
                            i -= 1;
                        }
                        this.buildContext.appendChildNode(fromKeywordBuilder.toSyntaxNode());
                        this.currentState = BuilderStates.FromKeyWord;
                    }
                    continue;
                }
                if (this.currentState == BuilderStates.FromKeyWord) {
                    if (token.kind() == TweetQlSyntaxKind.LeftBracket || token.kind() == TweetQlSyntaxKind.LeftParenthesis) {
                        this.currentState = BuilderStates.SystemObject;
                        if (systemObjectSyntaxBuilder == null) {
                            systemObjectSyntaxBuilder = new SystemObjectSyntaxBuilder(
                                    this.buildContext.getNode(),
                                    token.span().start(),
                                    token.fullSpan().start()
                            );
                        }
                        systemObjectSyntaxBuilder.appendChildToken(token);
                        continue;
                    }
                    if (userDefinedTypeSyntaxBuilder == null) {
                        userDefinedTypeSyntaxBuilder = new UserDefinedTypeSyntaxBuilder(
                                this.buildContext.getNode(),
                                token.span().start(),
                                token.fullSpan().start()
                        );
                    }
                    userDefinedTypeSyntaxBuilder.appendChildToken(token);
                    this.currentState = BuilderStates.UserDefined;
                    continue;
                }
                if (token.kind() == TweetQlSyntaxKind.WHERE) {
                    //
                    if (userDefinedTypeSyntaxBuilder != null) {
                        this.buildContext.getNode().addChildNode(userDefinedTypeSyntaxBuilder.toSyntaxNode());
                        userDefinedTypeSyntaxBuilder = null;
                    }
                    if (systemObjectSyntaxBuilder != null) {
                        this.buildContext.getNode().addChildNode(systemObjectSyntaxBuilder.toSyntaxNode());
                        systemObjectSyntaxBuilder = null;
                    }
                    this.currentState = BuilderStates.ParsedDefault;
                    continue;
                }
                if (this.currentState == BuilderStates.SystemObject) {
                    if (systemObjectSyntaxBuilder != null) {
                        systemObjectSyntaxBuilder.appendChildToken(token);
                    }
                }
                if (this.currentState == BuilderStates.UserDefined) {
                    if (userDefinedTypeSyntaxBuilder != null) {
                        userDefinedTypeSyntaxBuilder.appendChildToken(token);
                    }
                }
            }
            if (this.currentState != BuilderStates.ParsedDefault) {
                if (userDefinedTypeSyntaxBuilder != null) {
                    this.buildContext.getNode().addChildNode(userDefinedTypeSyntaxBuilder.toSyntaxNode());
                }
                if (systemObjectSyntaxBuilder != null) {
                    this.buildContext.getNode().addChildNode(systemObjectSyntaxBuilder.toSyntaxNode());
                }
            }
        }
    }

    public FromExpressionSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.specifiedRule(new FromExpressionSyntaxRule());
        this.rule.setContext(this);
    }


}
