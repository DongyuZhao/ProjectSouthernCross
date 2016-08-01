package project.southern_cross.code_analysis.core.parser;

import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.boot.BootLoader;
import project.southern_cross.code_analysis.core.config.SyntaxErrorRule;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.config.SyntaxParserConfig;
import project.southern_cross.code_analysis.core.syntax.RootSyntax;

import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
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

    private List<SyntaxParseRule> getAvailableParseRule() {
        return this.getSyntaxParserConfig().getAvailableParseRules(this.currentState);
    }

    private List<SyntaxErrorRule> getAvailableErrorRule() {
        return this.getSyntaxParserConfig().getAvailableErrorRules(this.currentState);
    }

    public SyntaxNode parse(String source) {
        Tokenizer tokenizer = new Tokenizer(BootLoader.getSyntaxFacts(this.language));
        List<SyntaxToken> tokenList = tokenizer.tokenize(source);
        RootSyntax root = new RootSyntax(0, 0, false, false);
        this.currentContextNode = root;
        for (int i = 0; i < tokenList.size(); i++) {
            SyntaxToken token = tokenList.get(i);
            boolean error = true;
            for (SyntaxParseRule parseRule : this.getAvailableParseRule()) {
                error = this.tryUpdateSyntaxTree(token, parseRule);
                if (!error) {
                    break;
                }
            }
            if (error) {
                boolean dealt = false;
                for (SyntaxErrorRule errorRule : this.getAvailableErrorRule()) {
                    ErrorDealtResult dealtResult = this.tryDealError(token, errorRule);
                    dealt = dealtResult.isDealt();
                    if (dealt) {
                        if (dealtResult.isNeedBackward()) {
                            i--;
                        }
                        break;
                    }
                }
                if (!dealt) {
                    this.currentContextNode.addChildToken(new SyntaxToken(token.getRawString(), token.getKind(), true, true));
                    break;
                }
            }
        }
        return root;
    }

    private boolean tryUpdateSyntaxTree(SyntaxToken token, SyntaxParseRule parseRule) {
        SyntaxParseResult result = parseRule.updateSyntaxTree(token, this.currentContextNode);
        boolean error = true;
        if (result.isModified()) {
            this.currentContextNode = result.getCurrentContextNode();
            this.currentState = result.getPostParserState();
            error = false;
        }
        return error;
    }

    private ErrorDealtResult tryDealError(SyntaxToken token, SyntaxErrorRule errorRule) {
        SyntaxErrorResult result = errorRule.updateSyntaxTree(token, this.currentContextNode);
        if (result.isModified()) {
            this.currentContextNode = result.getCurrentContextNode();
            this.currentState = result.getPostParserState();
        }
        return new ErrorDealtResult(result.isDealt(), result.isNeedBackward());
    }

    private class ErrorDealtResult {
        private boolean dealt;

        private boolean needBackward;

        public ErrorDealtResult(boolean dealt, boolean needBackward) {
            this.dealt = dealt;
            this.needBackward = needBackward;
        }

        public boolean isDealt() {
            return dealt;
        }

        public boolean isNeedBackward() {
            return needBackward;
        }
    }
}
