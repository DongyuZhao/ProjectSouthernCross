package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.FromKeywordSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by donggeliu on 24/05/2016.
 */
public class FromKeywordBuilder extends SyntaxNodeBuilder<FromKeywordSyntax> {
    private enum BuilderStates {
        Default,
        FromKeyword
    }
    private class FromKeywordSyntaxRule extends SyntaxNodeBuildRule<FromKeywordSyntax> {
        private BuilderStates currentState = BuilderStates.Default;
        @Override
        public void build() {
            for(SyntaxToken token: this.getChildTokens()) {
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.Default) {
                    if (token.kind() == TweetQlSyntaxKind.FROM) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.FromKeyword;
                        continue;
                    }
                }
                token.setUnexpected(true);
                this.buildContext.getNode().addChildToken(token);
                this.buildContext.getNode().setWithError(true);
            }
            if (this.currentState == BuilderStates.Default) {
                this.buildContext.getNode().addChildToken(
                        new SyntaxToken(
                                this.buildContext.getNode(),
                                "",
                                this.buildContext.getSpan().start(),
                                0,
                                this.buildContext.getSpan().start(),
                                0,
                                TweetQlSyntaxKind.FROM,
                                true,
                                false,
                                true
                        )
                );
                this.buildContext.getNode().setMissing(true);
                this.buildContext.getNode().setWithError(true);
            }
        }
    }

    public FromKeywordBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.node = new FromKeywordSyntax(parent, startSpan, 0, startFullSpan, 0, TweetQlSyntaxKind.FROM, false, false, false);
        this.specifiedRule(new FromKeywordSyntaxRule());
        this.rule.setContext(this);
    }
}