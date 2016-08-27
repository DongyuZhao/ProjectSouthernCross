package project.code_analysis.tweet_ql.syntax;

import project.code_analysis.core.ISyntaxParser;
import project.code_analysis.core.SyntaxToken;
import project.code_analysis.core.SyntaxUnit;
import project.code_analysis.core.syntax.nodes.CompilationUnitSyntax;
import project.code_analysis.tweet_ql.syntax.builders.CompileUnitBuilder;
import project.code_analysis.tweet_ql.syntax.lexers.TweetQlSyntaxLexer;

import java.util.List;

/**
 * ProjectSouthernCross
 * <p>
 * Created by Dy.Zhao on 2016/8/14.
 */
public class TweetQlSyntaxParser implements ISyntaxParser {
    private TweetQlSyntaxParser() {
    }

    public static TweetQlSyntaxParser create() {
        return new TweetQlSyntaxParser();
    }

    @Override
    public CompilationUnitSyntax parse(String source) {
        List<? extends SyntaxToken> tokenList = preProcessing(source);
        if (tokenList.stream().filter(SyntaxUnit::isError).count() == 0) {
            CompileUnitBuilder builder = new CompileUnitBuilder();
            tokenList.forEach(builder::append);
            return builder.build();
        }
        return new CompilationUnitSyntax(TweetQlSyntaxFacts.getInstance().getLanguage());
    }

    private List<? extends SyntaxToken> preProcessing(String source) {
        TweetQlTokenizer tokenizer = TweetQlTokenizer.create();
        TweetQlSyntaxLexer lexer = TweetQlSyntaxLexer.create();
        return lexer.lex(tokenizer.tokenize(source));
    }
}
