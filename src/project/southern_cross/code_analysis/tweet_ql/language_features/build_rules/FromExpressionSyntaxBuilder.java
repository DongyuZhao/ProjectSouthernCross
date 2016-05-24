package project.southern_cross.code_analysis.tweet_ql.language_features.build_rules;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxNodeBuilder;
import project.southern_cross.code_analysis.tweet_ql.language_features.FromExpressionSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by donggeliu on 24/05/2016.
 */
public class FromExpressionSyntaxBuilder extends SyntaxNodeBuilder<FromExpressionSyntax>{

    public enum BuilderStates{
        Default;
        FromKeyword;
        ;
        ;
        ;


    }

    public FromExpressionSyntaxBuilder(SyntaxNode parent, int startSpan, int startFullSpan) {
        super(parent, startSpan, startFullSpan);
    }






}
