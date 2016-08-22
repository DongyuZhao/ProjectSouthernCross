package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.syntax.CompilationUnitSyntax;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class SyntaxParserTest {
    @Test
    public void parse() throws Exception {
        ISyntaxParser parser = SyntaxParser.create();
        String source = "SELECT * FROM * WHERE t = \"u\", a WHERE b = \"c\";";
        CompilationUnitSyntax root = parser.parse(source);
        System.out.println(root.toString());
        Assert.assertEquals(source, root.getRawString());
    }

}