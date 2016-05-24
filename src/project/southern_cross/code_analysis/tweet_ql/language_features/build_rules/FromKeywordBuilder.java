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
 * <p>
 * Created by donggeliu on 24/05/2016.
 */
public class FromKeywordBuilder extends SyntaxNodeBuilder<FromKeywordSyntax> {
    private enum BuilderStates {
        Default,
        FromKeyword
    }
    private class FromKeywordSyntaxRule extends SyntaxNodeBuildRule<FromKeywordSyntax> {
        private FromKeywordBuilder.BuilderStates currentState = BuilderStates.Default;
        @Override
        public void build() {
            for(SyntaxToken token: this.getChildToken()) {
                if (this.currentState == BuilderStates.Default) {
                    if (token.kind() == TweetQlSyntaxKind.FROM) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.FromKeyword;
                        return;
                    }
                }
            }
        }
    }

    public FromKeywordBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
    }
}