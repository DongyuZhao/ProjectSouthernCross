package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.*;
import project.southern_cross.code_analysis.tweet_ql.language_features.*;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class CreateExpressionSyntaxBuilder extends SyntaxNodeBuilder<CreateExpressionSyntax> {
    private enum BuilderStates {
        Default,
        CreateKeyWord,
        FromKeyWord,
        InstanceAttribute,
        SubExpression,
        ParsedDefault
    }

    private class CreateExpressionSyntaxRule extends SyntaxNodeBuildRule<CreateExpressionSyntax> {
        private BuilderStates currentState = BuilderStates.Default;

        @Override
        public void build() {
            int skip = 0;
            UserDefinedTypeSyntaxBuilder userDefinedTypeSyntaxBuilder = null;
            FromExpressionSyntaxBuilder fromExpressionSyntaxBuilder = null;
            for(int i = 0; i < this.getChildTokens().size(); i ++) {
                SyntaxToken token = this.getChildTokens().get(i);
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    skip += 1;
                    continue;
                }
                if (this.currentState == BuilderStates.Default) {
                    if (i == skip) {
                        CreateKeywordBuilder createKeywordBuilder = new CreateKeywordBuilder(
                                this.buildContext.getNode(),
                                token.span().start(),
                                token.fullSpan().start()
                        );
                        if (token.kind() == TweetQlSyntaxKind.CREATE) {
                            createKeywordBuilder.appendChildToken(token);
                        } else {
                            i -= 1;
                        }
                        this.buildContext.appendChildNode(createKeywordBuilder.toSyntaxNode());
                        this.currentState = BuilderStates.CreateKeyWord;
                    }
                    continue;
                }
                if (this.currentState == BuilderStates.CreateKeyWord) {
                    if (token.kind() == TweetQlSyntaxKind.FROM) {
                        if (userDefinedTypeSyntaxBuilder != null) {
                            this.buildContext.getNode().addChildNode(userDefinedTypeSyntaxBuilder.toSyntaxNode());
                            userDefinedTypeSyntaxBuilder = null;
                        }
                        if (fromExpressionSyntaxBuilder == null) {
                            fromExpressionSyntaxBuilder = new FromExpressionSyntaxBuilder(
                                    this.buildContext.getNode(),
                                    token.span().start(),
                                    token.fullSpan().start()
                            );
                        }
                        fromExpressionSyntaxBuilder.appendChildToken(token);
                        this.currentState = BuilderStates.FromKeyWord;
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
                    continue;
                }
                if (this.currentState == BuilderStates.FromKeyWord) {
                    if (token.kind() == TweetQlSyntaxKind.SemiColon) {
                        this.buildContext.getNode().addChildToken(token);
                        if (fromExpressionSyntaxBuilder != null) {
                            this.buildContext.getNode().addChildNode(fromExpressionSyntaxBuilder.toSyntaxNode());
                            fromExpressionSyntaxBuilder = null;
                        }
                        this.currentState = BuilderStates.ParsedDefault;
                        continue;
                    }
                    fromExpressionSyntaxBuilder.appendChildToken(token);
                    continue;
                }
            }
            if (this.currentState != BuilderStates.ParsedDefault) {
                if (userDefinedTypeSyntaxBuilder != null) {
                    this.buildContext.getNode().addChildNode(userDefinedTypeSyntaxBuilder.toSyntaxNode());
                }
                if (fromExpressionSyntaxBuilder != null) {
                    this.buildContext.getNode().addChildNode(fromExpressionSyntaxBuilder.toSyntaxNode());
                }
            }
        }
    }

    public CreateExpressionSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.node = new CreateExpressionSyntax(parent, startSpan, 0, startFullSpan, 0, TweetQlSyntaxKind.CreateExpression, false, false, false);
        this.specifiedRule(new CreateExpressionSyntaxRule());
        this.rule.setContext(this);
    }


}
