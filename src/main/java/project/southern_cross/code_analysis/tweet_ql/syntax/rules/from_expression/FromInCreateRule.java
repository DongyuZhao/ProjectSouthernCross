package project.southern_cross.code_analysis.tweet_ql.syntax.rules.from_expression;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.annotation.SyntaxParseRuleClass;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.parser.SyntaxParseResult;
import project.southern_cross.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.southern_cross.code_analysis.tweet_ql.config.TweetQlSyntaxFacts;
import project.southern_cross.code_analysis.tweet_ql.config.TweetQlSyntaxParserStates;
import project.southern_cross.code_analysis.tweet_ql.syntax.CreateExpressionSyntax;
import project.southern_cross.code_analysis.tweet_ql.syntax.FromExpressionSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/2.
 */
@SyntaxParseRuleClass(
        language = TweetQlSyntaxFacts.LANGUAGE,
        prerequisiteStates = {
                TweetQlSyntaxParserStates.OBJECT_DECLARE_IN_CREATE
        }
)
public class FromInCreateRule implements SyntaxParseRule {
    @Override
    public SyntaxParseResult<? extends SyntaxNode> updateSyntaxTree(SyntaxToken nextToken, SyntaxNode syntaxTreeAnchor) {
        if (nextToken.getKind() == TweetQlSyntaxKind.FROM_SYNTAX_TOKEN) {
            FromExpressionSyntax node = new FromExpressionSyntax(false, false);
            node.addChildToken(nextToken);
            if (syntaxTreeAnchor.getClass().equals(CreateExpressionSyntax.class)) {
                syntaxTreeAnchor.addChildNode(node);
            } else {
                syntaxTreeAnchor.getParentNode().addChildNode(node);
            }
            return new SyntaxParseResult<>(node, TweetQlSyntaxParserStates.FROM_EXP);
        }
        return new SyntaxParseResult<>();
    }
}
