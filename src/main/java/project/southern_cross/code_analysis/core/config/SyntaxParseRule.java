package project.southern_cross.code_analysis.core.config;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.parser.SyntaxParseResult;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/14.
 */
public interface SyntaxParseRule {
    SyntaxParseResult<? extends SyntaxNode> updateSyntaxTree(SyntaxToken nextToken, SyntaxNode syntaxTreeAnchor);
}
