package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.syntax.nodes.structure_expressions.AttributeList;

/**
 * An implement of AbstractSyntaxNodeBuilder to build AttributeList node
 */
public class AttributeListBuilder extends AbstractSyntaxNodeBuilder<AttributeList> {
    @Override
    public AttributeList build() {
        this.root = new AttributeList();
        this.tokenList.forEach(t -> this.root.addChildToken(t));
        return this.root;
    }
}
