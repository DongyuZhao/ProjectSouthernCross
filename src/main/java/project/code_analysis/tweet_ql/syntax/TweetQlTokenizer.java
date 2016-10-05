package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.AbstractTokenizer;

/**
 * The implement of AbstractTokenizer for TweetQL
 */
public class TweetQlTokenizer extends AbstractTokenizer {
    /**
     * Get an instance of the tokenizer
     */
    protected TweetQlTokenizer() {
        super(TweetQlSyntaxFacts.getInstance(), TweetQlSyntaxFactory.create());
    }

    /**
     * Create a new instance of TweetQlTokenizer
     * @return the tokenizer instance
     */
    public static TweetQlTokenizer create() {
        return new TweetQlTokenizer();
    }
}
