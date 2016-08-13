package project.code_analysis.tweet_ql.semantic.binder;

import project.code_analysis.tweet_ql.semantic.SymbolInfo;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/13.
 */
public class PredefinedTypeBinder {
    public static SymbolInfo getStreamBindInfo() {
        SymbolInfo info = new SymbolInfo("twitter");
        // TODO::Bind all of the attribute of the predefined twitter stream class.
        return info;
    }
}
