package project.southern_cross.code_analysis.tweet_ql.syntax;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.tweet_ql.TweetQlSyntaxKind;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/2.
 */
public class UserDefinedTypeSyntax extends SyntaxNode {
    public UserDefinedTypeSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, missing, unexpected);
    }

    public UserDefinedTypeSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, missing, unexpected);
    }

    public UserDefinedTypeSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, end, missing, unexpected);
    }

    public UserDefinedTypeSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, end, fullEnd, missing, unexpected);
    }

    public UserDefinedTypeSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public UserDefinedTypeSyntax(SyntaxNode parent, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, missing, unexpected);
    }

    public UserDefinedTypeSyntax(SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, missing, unexpected);
    }

    public UserDefinedTypeSyntax(SyntaxNode parent, int start, int end, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, end, missing, unexpected);
    }

    public UserDefinedTypeSyntax(SyntaxNode parent, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, end, fullEnd, missing, unexpected);
    }

    public UserDefinedTypeSyntax(SyntaxNode parent, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(parent, TweetQlSyntaxKind.USER_DEFINED_TYPE_SYNTAX_NODE, start, end, fullStart, fullEnd, missing, unexpected);
    }
}
