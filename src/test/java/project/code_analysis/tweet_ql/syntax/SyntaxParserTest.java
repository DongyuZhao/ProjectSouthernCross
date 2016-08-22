package project.code_analysis.tweet_ql.syntax;

import org.junit.Assert;
import org.junit.Test;
import project.code_analysis.core.AbstractSyntaxKind;
import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.syntax.CompilationUnitSyntax;

/**
 * Created by Dy.Zhao on 2016/8/16.
 */
public class SyntaxParserTest {
    @Test
    public void parse() throws Exception {
        ISyntaxParser parser = SyntaxParser.create();
        CompilationUnitSyntax root = parser.parse("SELECT a, b, c FROM * WHERE t = \"u\";");
        Assert.assertEquals(AbstractSyntaxKind.COMPILATION_UNIT_SYNTAX, root.getKind());
    }

}