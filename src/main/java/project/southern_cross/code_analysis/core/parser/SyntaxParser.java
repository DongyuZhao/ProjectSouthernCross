package project.southern_cross.code_analysis.core.parser;

import project.southern_cross.code_analysis.core.SyntaxKind;
import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.SyntaxUnit;
import project.southern_cross.code_analysis.core.boot.BootLoader;
import project.southern_cross.code_analysis.core.config.SyntaxErrorRule;
import project.southern_cross.code_analysis.core.config.SyntaxFacts;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.config.SyntaxParserConfig;
import project.southern_cross.code_analysis.core.exceptions.UnsupportedLanguageException;
import project.southern_cross.code_analysis.core.syntax.RootSyntax;

import java.util.*;
import java.util.concurrent.TimeoutException;

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


    private SyntaxParser(String language) throws UnsupportedLanguageException {
        if (language != null) {
            this.language = language;
        } else {
            this.language = "";
        }
        this.currentState = this.getInitState();
    }

    public static SyntaxParser createParser(String language) throws TimeoutException, UnsupportedLanguageException {
        if (language == null) {
            throw new IllegalArgumentException("Parameter 'language' is null.");
        }
        SyntaxParser result = new SyntaxParser(language);
        if (BootLoader.isReady()) {
            return result;
        } else {
            if (BootLoader.isLoading()) {
                long startTimeStamp = (new Date()).getTime();
                while (!BootLoader.isReady()) {
                    if ((new Date()).getTime() - startTimeStamp > 10000) {
                        throw new TimeoutException("Loading cannot finish in");
                    }
                }
                return result;
            } else {
                if (!BootLoader.isReady()) {
                    BootLoader.load();
                }
                return result;
            }
        }
    }

    private SyntaxParserConfig getSyntaxParserConfig() throws UnsupportedLanguageException {
        Optional<SyntaxParserConfig> config = BootLoader.getParserConfig(this.language);
        if (config.isPresent()) {
            return config.get();
        } else {
            throw new UnsupportedLanguageException("The parser cannot support this language");
        }
    }

    private SyntaxFacts getSyntaxFacts() throws UnsupportedLanguageException {
        Optional<SyntaxFacts> facts = BootLoader.getSyntaxFacts(this.language);
        if (facts.isPresent()) {
            return facts.get();
        } else {
            throw new UnsupportedLanguageException("The parser cannot support this language");
        }
    }

    private List<Integer> getParserStates() throws UnsupportedLanguageException {
        return this.getSyntaxParserConfig().getStates();
    }

    private int getInitState() throws UnsupportedLanguageException {
        return this.getSyntaxParserConfig().getInitialState();
    }

    private Set<SyntaxParseRule> getAvailableParseRule() throws UnsupportedLanguageException {
        Optional<Map<Integer, Set<SyntaxParseRule>>> ruleMap = BootLoader.getParseRules(this.language);
        if (ruleMap.isPresent()) {
            Map<Integer, Set<SyntaxParseRule>> ruleSet = ruleMap.get();
            if (ruleSet.keySet().contains(this.currentState)) {
                return ruleSet.get(this.currentState);
            }
        } else {
            throw new UnsupportedLanguageException("The parser cannot support this language");
        }
        return new HashSet<>();
    }

    private Set<SyntaxErrorRule> getAvailableErrorRule() throws UnsupportedLanguageException {
        Optional<Map<Integer, Set<SyntaxErrorRule>>> ruleMap = BootLoader.getErrorRules(this.language);
        if (ruleMap.isPresent()) {
            Map<Integer, Set<SyntaxErrorRule>> ruleSet = ruleMap.get();
            if (ruleSet.keySet().contains(this.currentState)) {
                return ruleSet.get(this.currentState);
            }
        } else {
            throw new UnsupportedLanguageException("The parser cannot support this language");
        }
        return new HashSet<>();
    }

    public SyntaxNode parse(String source) throws UnsupportedLanguageException {
        Tokenizer tokenizer = new Tokenizer(this.getSyntaxFacts());
        List<SyntaxToken> tokenList = tokenizer.tokenize(source);
        SyntaxTriviaProcessor triviaProcessor = new SyntaxTriviaProcessor(language);

        List<? extends SyntaxUnit> updateTokenList = triviaProcessor.updateSyntaxTokenStream(tokenList);
        RootSyntax root = new RootSyntax(0, 0, false, false);
        this.currentContextNode = root;
        for (int i = 0; i < updateTokenList.size(); i++) {
            SyntaxUnit unit = updateTokenList.get(i);
            SyntaxToken token = this.getSyntaxFacts().isSyntaxToken(unit.getKind()) ? (SyntaxToken) unit : null;
            if (token == null) {
                continue;
            }
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
                    this.currentContextNode = root;
                    break;
                }
            }
        }
        if (!this.currentContextNode.equals(root)) {
            root.addChildNode(new SyntaxNode(SyntaxKind.ERROR, true, true));
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

        ErrorDealtResult(boolean dealt, boolean needBackward) {
            this.dealt = dealt;
            this.needBackward = needBackward;
        }

        boolean isDealt() {
            return dealt;
        }

        boolean isNeedBackward() {
            return needBackward;
        }
    }
}
