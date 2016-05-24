package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.tweet_ql.language_features.CreateExpressionSyntax;
import project.southern_cross.code_analysis.tweet_ql.language_features.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class CreateExpressionSyntaxBuilder extends SyntaxNodeBuilder<CreateExpressionSyntax> {
    public enum BuilderStates {
        Default,
        CreateKeyWord,
        InstanceAttribute,
        SubExpression
    }

    private class CreateExpressionSyntaxRule extends SyntaxNodeBuildRule<CreateExpressionSyntax> {
        private BuilderStates currentState = BuilderStates.Default;

        @Override
        public void build() {
            for(int i = 0; i < this.getChildToken().size(); i ++) {
                SyntaxToken token = this.getChildToken().get(i);
                boolean missing = false;
                if (this.currentState == BuilderStates.Default) {
                    if (i == 0) {
                        CreateKeywordBuilder createKeywordBuilder = new CreateKeywordBuilder(
                                this.buildContext.getNode(),
                                token.span().start(),
                                token.fullSpan().start()
                        );
                        if (token.kind() == TweetQlSyntaxKind.CREATE) {
                            createKeywordBuilder.appendChildToken(token);
                        }
                        this.buildContext.appendChildNode(createKeywordBuilder.toSyntaxNode());
                    }
                }
            }
        }
    }

    private CreateExpressionSyntaxRule rule = new CreateExpressionSyntaxRule();

    public CreateExpressionSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        rule.setContext(this);
    }


}
