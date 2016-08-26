package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.semantic.OperatorInfo;
import project.code_analysis.tweet_ql.semantic.SymbolInfo;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class EvaluableExpression extends TweetQlSyntaxNode {
    private OperatorInfo operatorInfo;
    private SymbolInfo returnValueSymbolInfo;

    public EvaluableExpression(ISyntaxKind kind) {
        super(kind);
    }

    public EvaluableExpression(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxNode parent, boolean missing, boolean unexpected) {
        super(kind, parent, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxNode parent, int start, boolean missing, boolean unexpected) {
        super(kind, parent, start, missing, unexpected);
    }

    public SymbolInfo getReturnValueSymbolInfo() {
        return returnValueSymbolInfo;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }
}
