package project.code_analysis.tweet_ql.semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/12.
 */
public class SymbolInfo {
    private String typeName;

    private HashMap<String, SymbolInfo> members = new HashMap<>();

    public String getTypeName() {
        return typeName;
    }

    public SymbolInfo(String typeName) {
        this.typeName = typeName;
    }

    public Map<String, SymbolInfo> getMembers() {
        return members;
    }

    public void addMember(SymbolInfo type, String name) {
        this.members.put(name, type);
    }
}
