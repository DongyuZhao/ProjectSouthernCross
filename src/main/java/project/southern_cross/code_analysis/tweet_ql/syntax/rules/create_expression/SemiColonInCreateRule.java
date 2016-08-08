package project.southern_cross.code_analysis.tweet_ql.syntax.rules.create_expression;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.annotation.SyntaxParseRuleClass;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.parser.SyntaxParseResult;
import project.southern_cross.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.southern_cross.code_analysis.tweet_ql.config.TweetQlSyntaxParserStates;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/14.
 */
@SyntaxParseRuleClass(
        language = "tweet_ql",
        prerequisiteStates = {TweetQlSyntaxParserStates.OBJECT_DECLARE_IN_FROM}
)
public class SemiColonInCreateRule implements SyntaxParseRule {
    @Override
    public SyntaxParseResult<? extends SyntaxNode> updateSyntaxTree(SyntaxToken nextToken, SyntaxNode syntaxTreeAnchor) {
        if (nextToken.getKind() == TweetQlSyntaxKind.SEMICOLON_TOKEN) {
            SyntaxNode node = syntaxTreeAnchor;
            while(node != null) {
                if (node.getKind() == TweetQlSyntaxKind.CREATE_SYNTAX_NODE) {
                    node.addChildToken(nextToken);
                    return new SyntaxParseResult<>(node.getParentNode(), TweetQlSyntaxParserStates.EXPRESSION_TERMINATED);
                }
                node = node.getParentNode();
            }
        }
        return new SyntaxParseResult<>();
    }
}
