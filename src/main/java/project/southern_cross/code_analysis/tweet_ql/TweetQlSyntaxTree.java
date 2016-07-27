package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.core.ParsedSyntaxTree;
import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxTree;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
public class TweetQlSyntaxTree {

    private ParsedSyntaxTree parsedSyntaxTree;

    public static TweetQlSyntaxTree parse(String source) {
        TweetQlSyntaxTree result = new TweetQlSyntaxTree();
        result.parsedSyntaxTree = SyntaxTree.parse(source, "tweet_ql");
        return result;
    }

    public ParsedSyntaxTree getParsedSyntaxTree() {
        return parsedSyntaxTree;
    }

    public SyntaxNode getRoot() {
        return this.getParsedSyntaxTree().getRoot();
    }
}
