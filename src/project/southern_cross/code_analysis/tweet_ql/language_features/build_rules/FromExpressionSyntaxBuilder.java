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
 *
 * Created by donggeliu on 24/05/2016.
 */
public class FromExpressionSyntaxBuilder extends SyntaxNodeBuilder<FromExpressionSyntax>{

    public enum BuilderStates {
        Default,
        FromKeyWord,
        InstanceAttribute,
        SubExpression
    }

    private class FromExpressionSyntaxRule extends SyntaxNodeBuildRule<FromExpressionSyntax> {
        private BuilderStates currentState = BuilderStates.Default;

        @Override
        public void build() {
            for(int i = 0; i < this.getChildToken().size(); i ++) {
                SyntaxToken token = this.getChildToken().get(i);
                boolean missing = false;
                if (this.currentState == BuilderStates.Default) {
                    if (i == 0) {
                        FromKeywordBuilder fromKeywordBuilder = new FromKeywordBuilder(
                                this.buildContext.getNode(),
                                token.span().start(),
                                token.fullSpan().start()
                        );
                        if (token.kind() == TweetQlSyntaxKind.FROM) {
                            fromKeywordBuilder.appendChildToken(token);
                        }
                        this.buildContext.appendChildNode(fromKeywordBuilder.toSyntaxNode());
                    }
                }
            }
        }
    }



    private FromExpressionSyntaxBuilder.FromExpressionSyntaxRule rule = new FromExpressionSyntaxBuilder.FromExpressionSyntaxRule();

    public FromExpressionSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        rule.setContext(this);
    }






}
