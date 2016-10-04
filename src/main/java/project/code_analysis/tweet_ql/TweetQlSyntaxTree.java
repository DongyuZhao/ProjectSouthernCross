package project.code_analysis.tweet_ql;

import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.SyntaxTree;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxParser;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/8/28.
 */
public class TweetQlSyntaxTree extends SyntaxTree {
    protected TweetQlSyntaxTree(ISyntaxParser parser) {
        super(parser);
    }

    /**
     * Parse the given text into a SyntaxTree
     * @param text the given text
     * @return the SyntaxTree
     */
    public static TweetQlSyntaxTree parseText(String text) {
        TweetQlSyntaxTree tree = new TweetQlSyntaxTree(TweetQlSyntaxParser.create());
        tree.parse(text);
        return tree;
    }
}
