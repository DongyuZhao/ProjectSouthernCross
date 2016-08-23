package project.code_analysis.tweet_ql;

import project.code_analysis.core.SyntaxTree;
import project.code_analysis.tweet_ql.syntax.TweetQlSyntaxParser;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class TweetQlSyntaxTree extends SyntaxTree {
    public TweetQlSyntaxTree() {
        super(TweetQlSyntaxParser.create());
    }
}
