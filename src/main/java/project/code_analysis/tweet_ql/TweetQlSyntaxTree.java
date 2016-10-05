package project.code_analysis.tweet_ql;

import project.code_analysis.core.SyntaxTree;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxParser;

/**
 * The implement of SyntaxTree for TweetQL
 */
public class TweetQlSyntaxTree extends SyntaxTree {
    /**
     * Get a new instance of a syntax tree initialed with the given parser
     *
     * @param parser the given parser
     */
    protected TweetQlSyntaxTree(TweetQlSyntaxParser parser) {
        super(parser);
    }

    /**
     * Parse the given plain text into an instance of TweetQlSyntaxTree
     * @param text the given plain text
     * @return the instance of TweetQlSyntaxTree
     */
    public static TweetQlSyntaxTree parseText(String text) {
        TweetQlSyntaxTree tree = new TweetQlSyntaxTree(TweetQlSyntaxParser.create());
        tree.parse(text);
        return tree;
    }
}
