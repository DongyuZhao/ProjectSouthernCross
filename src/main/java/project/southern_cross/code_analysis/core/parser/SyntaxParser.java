package project.southern_cross.code_analysis.core.parser;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.boot.BootLoader;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.config.SyntaxParserConfig;
import project.southern_cross.code_analysis.core.syntax.RootSyntax;

import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/14.
 */
public class SyntaxParser {

    private String language;

    private int currentState;

    private SyntaxNode currentContextNode;

    private SyntaxParser(String language) {
        this.language = language;
        this.currentState = this.getInitState();
    }

    public static SyntaxParser createParser(String language) {
        if (language == null) {
            throw new IllegalArgumentException("Parameter 'language' is null.");
        }
        return new SyntaxParser(language);
    }

    private SyntaxParserConfig getSyntaxParserConfig() {
        return BootLoader.getParserConfig(this.language);
    }

    private List<Integer> getParserStates() {
        return this.getSyntaxParserConfig().getStates();
    }

    private int getInitState() {
        return this.getSyntaxParserConfig().getInitialState();
    }

    private List<SyntaxParseRule> getAvailableRule() {
        return this.getSyntaxParserConfig().getAvailableRules(this.currentState);
    }

    public SyntaxNode parse(String source) {
        Tokenizer tokenizer = new Tokenizer(BootLoader.getSyntaxFacts(this.language));
        List<SyntaxToken> tokenList = tokenizer.tokenize(source);
        RootSyntax root = new RootSyntax(0, 0, false, false);
        this.currentContextNode = root;
        tokenList.forEach(token -> {
            this.getAvailableRule().forEach(rule -> {
                SyntaxParseResult result = rule.updateSyntaxTree(token, this.currentContextNode);
                if (result.isModified()) {
                    this.currentContextNode = result.getCurrentContextNode();
                    this.currentState = result.getPostParserState();
                }
            });
        });
        return root;
    }
}
