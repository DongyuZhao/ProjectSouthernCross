package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.syntax.nodes.AttributeListSyntax;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/15.
 */
public class AttributeListBuilder extends AbstractSyntaxNodeBuilder<AttributeListSyntax> {
    private ParseStates currentState = ParseStates.ROOT;

    public AttributeListSyntax build() {
        this.root = new AttributeListSyntax();
        UserDefinedTypeListBuilder<AttributeListSyntax> builder = new UserDefinedTypeListBuilder<>(this.root);
        this.tokenList.forEach(builder::append);
        return builder.build();
    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
    }
}
