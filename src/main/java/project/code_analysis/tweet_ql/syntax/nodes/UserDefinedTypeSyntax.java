package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxKind;
import project.code_analysis.tweet_ql.semantic.SymbolInfo;
import project.code_analysis.tweet_ql.semantic.binder.PredefinedTypeBinder;
import project.code_analysis.tweet_ql.syntax.tokens.IdentifierToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class UserDefinedTypeSyntax extends SyntaxNode {
    public UserDefinedTypeSyntax() {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, end, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, end, fullEnd, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, end, fullStart, fullEnd, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, end, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, end, fullEnd, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxKind.USER_DEFINED_TYPE_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    private SymbolInfo symbolInfo;

    public SymbolInfo getSymbolInfo() {
        return symbolInfo;
    }

    public IdentifierToken getIdentifierToken() {
        if (this.hasChildToken() && this.getChildTokens().get(0).getKind() == TweetQlSyntaxKind.IDENTIFIER_TOKEN) {
            return (IdentifierToken) this.getChildTokens().get(0);
        }
        return null;
    }
}
