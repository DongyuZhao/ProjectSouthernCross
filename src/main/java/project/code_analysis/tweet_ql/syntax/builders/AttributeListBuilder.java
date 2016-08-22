package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.tweet_ql.syntax.nodes.AttributeListSyntax;

import java.util.ArrayList;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class AttributeListBuilder {
    private AttributeListSyntax root;
    private ArrayList<SyntaxToken> tokenList = new ArrayList<>();
    private ArrayList<UserDefinedTypeBuilder> streamBuilderList = new ArrayList<>();
    private int currentBuilderPointer = -1;
    private ParseStates currentState = ParseStates.ROOT;

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public AttributeListSyntax build() {
        this.root = new AttributeListSyntax();
        UserDefinedTypeListBuilder builder = new UserDefinedTypeListBuilder(this.root);
        this.tokenList.forEach(builder::append);
        return (AttributeListSyntax) builder.build();
    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
    }
}
