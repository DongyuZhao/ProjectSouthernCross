package project.southern_cross.code_analysis.tweet_ql;

import project.southern_cross.code_analysis.SyntaxNode;
import project.southern_cross.code_analysis.SyntaxTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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

    public TweetQlSyntaxTree(SyntaxNode root)
    {
        super(root);
    }

    public static TweetQlSyntaxTree parse(String source) {
        TweetQlSyntaxParser_v2 parser = new TweetQlSyntaxParser_v2(source);
        return new TweetQlSyntaxTree(parser.parse());
    }

    public static TweetQlSyntaxTree parseFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            String source = new String(Files.readAllBytes(path));
            TweetQlSyntaxParser_v2 parser = new TweetQlSyntaxParser_v2(source);
            return new TweetQlSyntaxTree(parser.parse());
        }
        throw new IOException("File with path '" + filePath + "' is missing.");
    }
}
