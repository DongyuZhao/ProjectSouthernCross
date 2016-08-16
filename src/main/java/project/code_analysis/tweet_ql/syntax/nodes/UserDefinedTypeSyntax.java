package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.TweetQlSyntaxNodeKind;
import project.code_analysis.tweet_ql.TweetQlSyntaxTokenKind;
import project.code_analysis.tweet_ql.semantic.SymbolInfo;
import project.code_analysis.tweet_ql.semantic.binder.PredefinedTypeBinder;
import project.code_analysis.tweet_ql.syntax.tokens.IdentifierToken;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/11.
 */
public class UserDefinedTypeSyntax extends SyntaxNode {
    private SymbolInfo symbolInfo;

    public UserDefinedTypeSyntax() {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, end, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, end, fullEnd, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, end, fullStart, fullEnd, missing, unexpected);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, end, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, end, fullEnd, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public UserDefinedTypeSyntax(int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(TweetQlSyntaxNodeKind.USER_DEFINED_TYPE_NODE, start, end, fullStart, fullEnd, missing, unexpected, parent);
        this.symbolInfo = PredefinedTypeBinder.getStreamBindInfo();
    }

    public SymbolInfo getSymbolInfo() {
        return symbolInfo;
    }

    public IdentifierToken getIdentifierNode() {
        if (this.hasChildNode() && this.getChildTokens().get(0).getKind() == TweetQlSyntaxTokenKind.IDENTIFIER_TOKEN) {
            return (IdentifierToken) this.getChildTokens().get(0);
        }
        return null;
    }

    public StreamFilterExpressionSyntax getStreamFilter() {
        if (this.hasChildNode() && this.getChildNodes().get(0).getKind() == TweetQlSyntaxNodeKind.STREAM_FILTER_EXPRESSION_NODE) {
            return (StreamFilterExpressionSyntax) this.getChildNodes().get(0);
        }
        return new StreamFilterExpressionSyntax();
    }

    @Override
    public String getRawString() {
        return this.childTokens.get(0).getRawString();
    }
}
