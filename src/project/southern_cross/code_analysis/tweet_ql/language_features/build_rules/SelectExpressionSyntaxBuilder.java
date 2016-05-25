package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuildRule;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.tweet_ql.language_features.SelectExpressionSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/25 0025.
 */
public class SelectExpressionSyntaxBuilder extends SyntaxNodeBuilder<SelectExpressionSyntax> {
    private enum BuilderStates {
        Default
    }

    private class SelectExpressionSyntanxBuildRule extends SyntaxNodeBuildRule<SelectExpressionSyntax> {

        @Override
        public void build() {

        }
    }

    public SelectExpressionSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
        this.specifiedRule(new SelectExpressionSyntanxBuildRule());
        this.rule.setContext(this);
    }
}
