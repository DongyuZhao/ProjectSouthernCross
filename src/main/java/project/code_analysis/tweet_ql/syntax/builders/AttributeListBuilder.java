package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.syntax.nodes.AttributeList;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/4.
 */
public class AttributeListBuilder extends AbstractSyntaxNodeBuilder<AttributeList> {
    @Override
    public AttributeList build() {
        this.root = new AttributeList();
        this.tokenList.forEach(t -> this.root.addChildToken(t));
        return this.root;
    }
}
