package project.code_analysis.tweet_ql.semantic;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class BinaryOperatorInfo extends OperatorInfo {
    private SymbolInfo acceptableLeftSubExpressionType;
    private SymbolInfo acceptableRightSubExpressionType;

    public BinaryOperatorInfo(SymbolInfo returnValueInfo, SymbolInfo acceptableLeftSubExpressionType, SymbolInfo acceptableRightSubExpressionType) {
        super(returnValueInfo);
        this.acceptableLeftSubExpressionType = acceptableLeftSubExpressionType;
        this.acceptableRightSubExpressionType = acceptableRightSubExpressionType;
    }

    public SymbolInfo getAcceptableLeftSubExpressionType() {
        return acceptableLeftSubExpressionType;
    }

    public SymbolInfo getAcceptableRightSubExpressionType() {
        return acceptableRightSubExpressionType;
    }
}
