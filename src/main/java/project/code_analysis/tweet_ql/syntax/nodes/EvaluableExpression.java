package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxNode;
import project.code_analysis.tweet_ql.semantic.OperatorInfo;
import project.code_analysis.tweet_ql.semantic.SymbolInfo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class EvaluableExpression extends SyntaxNode {
    public EvaluableExpression(ISyntaxKind kind) {
        super(kind);
    }

    public EvaluableExpression(ISyntaxKind kind, boolean missing, boolean unexpected) {
        super(kind, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, boolean missing, boolean unexpected) {
        super(kind, start, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected) {
        super(kind, start, end, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullEnd, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected);
    }

    public EvaluableExpression(ISyntaxKind kind, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, missing, unexpected, parent);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, missing, unexpected, parent);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, int end, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, missing, unexpected, parent);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, int end, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, fullEnd, missing, unexpected, parent);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, int end, int fullStart, int fullEnd, boolean missing, boolean unexpected, SyntaxNode parent) {
        super(kind, start, end, fullStart, fullEnd, missing, unexpected, parent);
    }

    private OperatorInfo operatorInfo;

    private SymbolInfo returnValueSymbolInfo;

    public SymbolInfo getReturnValueSymbolInfo() {
        return returnValueSymbolInfo;
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }
}
