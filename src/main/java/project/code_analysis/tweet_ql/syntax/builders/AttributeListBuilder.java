package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.syntax.nodes.AttributeListSyntax;
import project.code_analysis.tweet_ql.syntax.nodes.CreateExpressionSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class AttributeListBuilder {
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public AttributeListSyntax build() {
        return null;
    }
}
