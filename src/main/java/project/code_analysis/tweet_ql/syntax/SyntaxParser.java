package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.SyntaxTokenizer;
import project.code_analysis.core.SyntaxUnit;
import project.code_analysis.core.syntax.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.syntax.builders.CompileUnitBuilder;

import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class SyntaxParser {
    public CompilationUnitSyntax parse(String source) {

        List<? extends SyntaxToken> tokenList = preProcessing(source);
        if (tokenList.stream().filter(SyntaxUnit::isError).count() == 0) {
            CompileUnitBuilder builder = new CompileUnitBuilder();

            return builder.build();
        }
        return null;
    }

    private List<? extends SyntaxToken> preProcessing(String source) {
        SyntaxTokenizer tokenizer = new SyntaxTokenizer(TweetQlSyntaxFacts.getInstance());
        SyntaxLexer lexer = new SyntaxLexer();
        return lexer.lex(lexer.transformTokens(tokenizer.tokenize(source)));
    }
}
