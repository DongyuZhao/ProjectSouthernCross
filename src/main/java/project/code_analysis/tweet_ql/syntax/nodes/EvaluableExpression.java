package project.code_analysis.tweet_ql.syntax.nodes;

import project.code_analysis.core.ISyntaxKind;
import project.code_analysis.core.SyntaxError;
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

    public EvaluableExpression(ISyntaxKind kind) {
        super(kind);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxError error) {
        super(kind, error);
    }

    public EvaluableExpression(ISyntaxKind kind, int start, SyntaxError error) {
        super(kind, start, error);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxNode parent, SyntaxError error) {
        super(kind, parent, error);
    }

    public EvaluableExpression(ISyntaxKind kind, SyntaxNode parent, int start, SyntaxError error) {
        super(kind, parent, start, error);
    }

    public SymbolInfo getReturnValueSymbolInfo() {
        return this.getOperatorInfo().getReturnValueInfo();
    }

    public OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }
}
