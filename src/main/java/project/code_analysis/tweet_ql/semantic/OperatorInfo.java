package project.code_analysis.tweet_ql.semantic;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class OperatorInfo {
    private SymbolInfo returnValueInfo;

    public OperatorInfo(SymbolInfo returnValueInfo) {
        this.returnValueInfo = returnValueInfo;
    }

    public SymbolInfo getReturnValueInfo() {
        return returnValueInfo;
    }
}
