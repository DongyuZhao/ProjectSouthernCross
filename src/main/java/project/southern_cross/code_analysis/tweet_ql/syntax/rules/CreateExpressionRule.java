package project.southern_cross.code_analysis.tweet_ql.syntax.rules;

import project.southern_cross.code_analysis.core.SyntaxKind;
import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.annotation.SyntaxRuleClass;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.parser.SyntaxParseResult;
import project.southern_cross.code_analysis.tweet_ql.syntax.CreateExpressionSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
@SyntaxRuleClass(language = "tweet_ql", prerequisiteState = SyntaxKind.ROOT)
public class CreateExpressionRule implements SyntaxParseRule {
    @Override
    public SyntaxParseResult<CreateExpressionSyntax> updateSyntaxTree(SyntaxToken nextToken, SyntaxNode syntaxTreeAnchor) {
        return null;
    }
}
