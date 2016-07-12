package project.southern_cross.code_analysis.tweet_ql.language_features.syntax_rules;

import project.southern_cross.code_analysis.SyntaxKind;
import project.southern_cross.code_analysis.annotations.SyntaxRule;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class RootSyntaxParseRule {
    @SyntaxRule(language = "TweetQl", contextSyntaxKind = SyntaxKind.Root)
    public void parse(){

    }
}
