package project.southern_cross.code_analysis.tweet_ql.syntax.rules.create_expression;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.annotation.SyntaxParseRuleClass;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.parser.SyntaxParseResult;
import project.southern_cross.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.southern_cross.code_analysis.tweet_ql.config.TweetQlSyntaxParserStates;
import project.southern_cross.code_analysis.tweet_ql.syntax.UserDefinedTypeSyntax;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/2.
 */
@SyntaxParseRuleClass(
        language = "tweet_ql",
        prerequisiteStates = {
                TweetQlSyntaxParserStates.CREATE_EXPRESSION,
                TweetQlSyntaxParserStates.COMMA_AFTER_OBJECT_IN_CREATE
        }
)
public class ObjectInCreateRule implements SyntaxParseRule {
    @Override
    public SyntaxParseResult<? extends SyntaxNode> updateSyntaxTree(SyntaxToken nextToken, SyntaxNode syntaxTreeAnchor) {
        if (nextToken.getKind() == TweetQlSyntaxKind.UN_DETERMINED_SYNTAX_TOKEN) {
            UserDefinedTypeSyntax node = new UserDefinedTypeSyntax(false, false);
            node.addChildToken(nextToken);
            syntaxTreeAnchor.addChildNode(node);
            return new SyntaxParseResult<>(node, TweetQlSyntaxParserStates.OBJECT_DECLARE_IN_CREATE);
        }
        return new SyntaxParseResult<>();
    }
}
