package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.SyntaxTree;
import project.southern_cross.code_analysis.Tokenizer;

import java.util.ArrayList;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxTree extends SyntaxTree {
    public TweetQlSyntaxTree() {
        super();
    }

    public TweetQlSyntaxTree(String filePath) {
        super(filePath);
    }

    public TweetQlSyntaxTree(SyntaxNode root)
    {
        super(root);
    }

    @Override
    public void ParseSource(String source) {

    }

}
