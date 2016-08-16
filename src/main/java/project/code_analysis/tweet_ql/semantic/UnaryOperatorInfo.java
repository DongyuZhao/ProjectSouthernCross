package project.code_analysis.tweet_ql.semantic;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class UnaryOperatorInfo extends OperatorInfo {
    private SymbolInfo acceptableSubExpressionType;

    public UnaryOperatorInfo(SymbolInfo returnValueInfo, SymbolInfo acceptableSubExpressionType) {
        super(returnValueInfo);
        this.acceptableSubExpressionType = acceptableSubExpressionType;
    }

    public SymbolInfo getAcceptableSubExpressionType() {
        return acceptableSubExpressionType;
    }
}
