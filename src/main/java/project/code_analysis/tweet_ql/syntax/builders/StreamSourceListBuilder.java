package project.code_analysis.tweet_ql.syntax.builders;

import project.code_analysis.core.syntax.builders.AbstractSyntaxNodeBuilder;
import project.code_analysis.tweet_ql.TweetQlTokenKind;
import project.code_analysis.tweet_ql.syntax.nodes.StreamSourceList;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/4.
 */
public class StreamSourceListBuilder extends AbstractSyntaxNodeBuilder<StreamSourceList> {
    private StreamSourceBuilder streamSourceBuilder;

    @Override
    public StreamSourceList build() {
        this.root = new StreamSourceList();
        this.streamSourceBuilder = new StreamSourceBuilder();
        this.tokenList.forEach(token -> {
            switch ((TweetQlTokenKind) token.getKind()) {
                case COMMA_TOKEN:
                    if (this.streamSourceBuilder != null) {
                        this.root.addChildNode(this.streamSourceBuilder.build());
                    }
                    this.root.addChildToken(token);
                    this.streamSourceBuilder = new StreamSourceBuilder();
                    break;
                default:
                    if (this.streamSourceBuilder != null) {
                        this.streamSourceBuilder.append(token);
                    }
                    break;
            }
        });
        if (this.streamSourceBuilder != null) {
            this.root.addChildNode(this.streamSourceBuilder.build());
        }
        return root;
    }
}
