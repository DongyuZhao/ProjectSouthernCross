package project.southern_cross.code_analysis.core;

import project.southern_cross.code_analysis.core.boot.BootLoader;
import project.southern_cross.code_analysis.core.parser.SyntaxParser;
import project.southern_cross.code_analysis.core.parser.SyntaxTriviaProcessor;
import project.southern_cross.code_analysis.core.parser.Tokenizer;

import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/16.
 */
public class SyntaxTree {
    private SyntaxNode root;

    protected static SyntaxTree parse(String source, String language) {
        Tokenizer tokenizer = new Tokenizer(BootLoader.getSyntaxFacts(language));
        List<SyntaxToken> tokenList = tokenizer.tokenize(source);
        SyntaxTriviaProcessor triviaProcessor = new SyntaxTriviaProcessor(language);

        List<? extends SyntaxUnit> updateTokenList = triviaProcessor.updateSyntaxTokenStream(tokenList);

        // TODO:: diagnose and determine the trivia's parent.

        SyntaxTree tree = new SyntaxTree();

        SyntaxParser parser = SyntaxParser.createParser(language);
        tree.root = parser.parse(source);
        return tree;
    }
}
