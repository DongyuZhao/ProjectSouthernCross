package project.southern_cross.code_analysis.tweet_ql.syntax.rules.CreateExpression;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.annotation.SyntaxRuleClass;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.parser.SyntaxParseResult;
import project.southern_cross.code_analysis.tweet_ql.config.TweetQlSyntaxParserStates;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/2.
 */
@SyntaxRuleClass(
        language = "tweet_ql",
        prerequisiteState = {
                TweetQlSyntaxParserStates.OBJECT_DECLARE_IN_CREATE
        }
)
public class CommaAfterObjectInCreateRule implements SyntaxParseRule {
    @Override
    public SyntaxParseResult<? extends SyntaxNode> updateSyntaxTree(SyntaxToken nextToken, SyntaxNode syntaxTreeAnchor) {
        if (nextToken.getKind() == TweetQlSyntaxParserStates.OBJECT_DECLARE_IN_CREATE) {
            syntaxTreeAnchor.addChildToken(nextToken);
            return new SyntaxParseResult<>(syntaxTreeAnchor.getParentNode(), TweetQlSyntaxParserStates.COMMA_AFTER_OBJECT_IN_CREATE);
        }
        return new SyntaxParseResult<>();
    }
}
