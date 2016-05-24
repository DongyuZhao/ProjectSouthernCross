package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.CreateKeywordSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class CreateKeywordBuilder extends SyntaxNodeBuilder<CreateKeywordSyntax> {
    private enum BuilderStates {
        Default,
        CreateKeyword
    }
    private class CreateKeywordSyntaxRule extends SyntaxNodeBuildRule<CreateKeywordSyntax> {
        private CreateKeywordBuilder.BuilderStates currentState = BuilderStates.Default;
        @Override
        public void build() {
            for(SyntaxToken token: this.getChildToken()) {
                if (this.currentState == BuilderStates.Default) {
                    if (token.kind() == TweetQlSyntaxKind.CREATE) {
                        this.buildContext.getNode().addChildToken(token);
                        this.currentState = BuilderStates.CreateKeyword;
                        return;
                    }
                }
            }
        }
    }

    public CreateKeywordBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
    }
}