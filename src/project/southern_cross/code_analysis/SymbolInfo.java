package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/5/24 0024.
 */
public class SymbolInfo {
    private String name = "";

    public SymbolInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
