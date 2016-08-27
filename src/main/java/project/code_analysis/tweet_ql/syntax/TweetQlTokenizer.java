package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.AbstractTokenizer;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/27.
 */
public class TweetQlTokenizer extends AbstractTokenizer {
    protected TweetQlTokenizer() {
        super(TweetQlSyntaxFacts.getInstance(), TweetQlSyntaxFactory.create());
    }

    public static TweetQlTokenizer create() {
        return new TweetQlTokenizer();
    }
}
