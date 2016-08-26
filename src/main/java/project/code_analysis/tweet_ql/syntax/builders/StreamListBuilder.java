package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.syntax.nodes.StreamListSyntax;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class StreamListBuilder extends AbstractSyntaxNodeBuilder<StreamListSyntax> {
    private ParseStates currentState = ParseStates.ROOT;

    public StreamListSyntax build() {
        this.root = new StreamListSyntax();
        UserDefinedTypeListBuilder<StreamListSyntax> builder = new UserDefinedTypeListBuilder<>(this.root);
        this.tokenList.forEach(builder::append);
        return builder.build();
    }

    private enum ParseStates {
        ROOT,
        AFTER_IDENTIFIER,
        AFTER_COMMA,
    }
}
