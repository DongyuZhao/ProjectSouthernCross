package project.southern_cross.code_analysis.core.parser;

import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import project.southern_cross.code_analysis.core.SyntaxKind;
import project.southern_cross.code_analysis.core.SyntaxNode;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.SyntaxUnit;
import project.southern_cross.code_analysis.core.annotation.SyntaxErrorRuleClass;
import project.southern_cross.code_analysis.core.annotation.SyntaxFactsClass;
import project.southern_cross.code_analysis.core.annotation.SyntaxParseRuleClass;
import project.southern_cross.code_analysis.core.annotation.SyntaxParserConfigClass;
import project.southern_cross.code_analysis.core.config.SyntaxErrorRule;
import project.southern_cross.code_analysis.core.config.SyntaxFacts;
import project.southern_cross.code_analysis.core.config.SyntaxParseRule;
import project.southern_cross.code_analysis.core.config.SyntaxParserConfig;
import project.southern_cross.code_analysis.core.exceptions.UnsupportedLanguageException;
import project.southern_cross.code_analysis.core.parser.built_in.SyntaxParserStates;
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

    private SyntaxParserConfig syntaxParserConfig;

    private SyntaxFacts syntaxFacts;

    private Map<Integer, Set<SyntaxParseRule>> syntaxParseRules = new HashMap<>();

    private Map<Integer, Set<SyntaxErrorRule>> syntaxErrorRules = new HashMap<>();

    private SyntaxParser(String language) throws UnsupportedLanguageException {
        if (language != null) {
            this.language = language;
        } else {
            this.language = "";
        }
        this.loadSyntaxFacts();
        this.loadSyntaxParserConfig();
        this.loadSyntaxParseRule();
        this.loadSyntaxErrorRule();
        //this.currentState = this.getInitStateInNode();
    }

    public static SyntaxParser createParser(String language) throws TimeoutException, UnsupportedLanguageException {
        if (language == null) {
            throw new IllegalArgumentException("Parameter 'language' is null.");
        }
        return new SyntaxParser(language);
    }

    private void loadSyntaxParserConfig() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxParserConfigClass.class)).forEach(c -> {
            if (SyntaxParserConfig.class.isAssignableFrom(c)) {
                if (c.getAnnotation(SyntaxParserConfigClass.class).language().toLowerCase().equals(this.language)) {
                    try {
                        this.syntaxParserConfig = (SyntaxParserConfig) (c.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadSyntaxFacts() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxFactsClass.class)).forEach(c -> {
            if (SyntaxFacts.class.isAssignableFrom(c)) {
                if (c.getAnnotation(SyntaxFactsClass.class).language().toLowerCase().equals(this.language)) {
                    try {
                        this.syntaxFacts = (SyntaxFacts) (c.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadSyntaxParseRule() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxParseRuleClass.class)).forEach(c -> {
            if (SyntaxParseRule.class.isAssignableFrom(c)) {
                if (c.getAnnotation(SyntaxParseRuleClass.class).language().toLowerCase().equals(this.language)) {
                    try {
                        for (int prerequisiteState : c.getAnnotation(SyntaxParseRuleClass.class).prerequisiteStates()) {
                            if (!this.syntaxParseRules.keySet().contains(prerequisiteState)) {
                                this.syntaxParseRules.put(prerequisiteState, new HashSet<>());
                            }
                            this.syntaxParseRules.get(prerequisiteState).add((SyntaxParseRule) (c.newInstance()));
                        }
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadSyntaxErrorRule() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxErrorRuleClass.class)).forEach(c -> {
            if (SyntaxErrorRule.class.isAssignableFrom(c)) {
                if (c.getAnnotation(SyntaxErrorRuleClass.class).language().toLowerCase().equals(this.language)) {
                    try {
                        for (int prerequisiteState : c.getAnnotation(SyntaxErrorRuleClass.class).prerequisiteStates()) {
                            if (!this.syntaxErrorRules.keySet().contains(prerequisiteState)) {
                                this.syntaxErrorRules.put(prerequisiteState, new HashSet<>());
                            }
                            this.syntaxErrorRules.get(prerequisiteState).add((SyntaxErrorRule) (c.newInstance()));
                        }
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private SyntaxParserConfig getSyntaxParserConfig() {
        return this.syntaxParserConfig;
    }

    private SyntaxFacts getSyntaxFacts() {
        return this.syntaxFacts;
    }

    private List<Integer> getParserStates() throws UnsupportedLanguageException {
        return this.getSyntaxParserConfig().getStates();
    }

    private int getInitStateInNode(SyntaxNode node) throws UnsupportedLanguageException {
        return this.getSyntaxParserConfig().getInitialStateInNode(node);
    }

    private Set<SyntaxParseRule> getAvailableParseRule() throws UnsupportedLanguageException {
        if (this.syntaxParseRules.keySet().contains(this.currentState)) {
            return this.syntaxParseRules.get(this.currentState);
        }
        return new HashSet<>();
    }

    private Set<SyntaxErrorRule> getAvailableErrorRule() throws UnsupportedLanguageException {
        if (this.syntaxErrorRules.keySet().contains(this.currentState)) {
            return this.syntaxErrorRules.get(this.currentState);
        }
        return new HashSet<>();
    }

    public SyntaxNode parse(String source) throws UnsupportedLanguageException {
        Tokenizer tokenizer = new Tokenizer(this.getSyntaxFacts());
        List<SyntaxToken> tokenList = tokenizer.tokenize(source);
        SyntaxTriviaProcessor triviaProcessor = new SyntaxTriviaProcessor(language);

        List<? extends SyntaxUnit> updateTokenList = triviaProcessor.updateSyntaxTokenStream(tokenList);
        RootSyntax root = new RootSyntax(0, 0, false, false);
        this.currentState = this.getInitStateInNode(root);
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
            if (result.getPostParserState() == SyntaxParserStates.EXPRESSION_TERMINATED) {
                try {
                    this.currentState = this.getInitStateInNode(this.currentContextNode);
                } catch (UnsupportedLanguageException e) {
                    e.printStackTrace();
                }
            } else {
                this.currentState = result.getPostParserState();
            }
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
