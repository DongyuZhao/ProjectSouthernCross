package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.SelectKeywordSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by donggeliu on 1/06/2016.
 */
public class SelectKeywordBuilder extends SyntaxNodeBuilder<SelectKeywordSyntax> {
    private enum BuilderStates {
        Default,
        SelectKeyword,
    }
    private class SelectKeywordSyntaxRule extends SyntaxNodeBuildRule<SelectKeywordSyntax> {
        private BuilderStates currentState = BuilderStates.Default;
        @Override
        public void build() {
            for(SyntaxToken token: this.getChildTokens()) {
                if (token.kind() == TweetQlSyntaxKind.ChangeLine) {
                    this.buildContext.getNode().addChildToken(token);
                    continue;
                }
                if (this.currentState == BuilderStates.Default) {
                    if (token.kind() == TweetQlSyntaxKind.SELECT) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.SelectKeyword;
                        continue;
                    }
                }
                token.setUnexpected(true);
                this.buildContext.getNode().addChildToken(token);
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
                                TweetQlSyntaxKind.SELECT,
                                true,
                                false,
                                true
                        )
                );
                this.buildContext.getNode().setMissing(true);
            }
        }
    }

    public SelectKeywordBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.node = new SelectKeywordSyntax(parent, startSpan, 0, startFullSpan, 0, TweetQlSyntaxKind.SELECT, false, false, false);
        this.specifiedRule(new SelectKeywordSyntaxRule());
        this.rule.setContext(this);
    }
}
