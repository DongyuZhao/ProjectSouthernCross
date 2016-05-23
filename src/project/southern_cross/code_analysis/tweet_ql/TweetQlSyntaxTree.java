package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxToken;
import project.southern_cross.code_analysis.SyntaxTree;
import project.southern_cross.code_analysis.Tokenizer;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/17 0017.
 */
public class TweetQlSyntaxTree extends SyntaxTree {
    public TweetQlSyntaxTree(String source) {
        super(source);
    }

    public TweetQlSyntaxTree(String source, String filePath) {
        super(source, filePath);
    }

    @Override
    public void ParseSource(String source) {

    }

}
