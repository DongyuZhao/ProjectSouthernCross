package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class SymbolInfo {
    private String type = "";
    private String convertedType = "";

    public SymbolInfo(String type) {
        this.type = type;
        //this.convertedType = type;
    }

    public SymbolInfo(String type, String convertedType) {
        this.type = type;
        this.convertedType = convertedType;
    }

    public String getType() {
        return type;
    }

    public String getConvertedType() {
        return convertedType;
    }
}
