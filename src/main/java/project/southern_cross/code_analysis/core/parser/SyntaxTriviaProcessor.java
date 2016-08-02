package project.southern_cross.code_analysis.core.parser;

import org.atteo.classindex.ClassFilter;
import org.atteo.classindex.ClassIndex;
import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.SyntaxTrivia;
import project.southern_cross.code_analysis.core.SyntaxUnit;
import project.southern_cross.code_analysis.core.annotation.SyntaxTriviaRuleClass;
import project.southern_cross.code_analysis.core.config.SyntaxTriviaRule;

import java.util.*;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/24.
 */
public class SyntaxTriviaProcessor {

    private String language;

    private SyntaxTriviaRule currentApplyingRule;

    private SyntaxTrivia currentSyntaxTrivia;

    private Set<SyntaxTriviaRule> syntaxTriviaRules = new HashSet<>();

    public SyntaxTriviaProcessor(String language) {
        this.language = language;
        this.loadSyntaxTriviaRules();
    }

    private void loadSyntaxTriviaRules() {
        ClassFilter.only().topLevel().from(ClassIndex.getAnnotated(SyntaxTriviaRuleClass.class)).forEach(c -> {
            if (SyntaxTriviaRule.class.isAssignableFrom(c)) {
                if (c.getAnnotation(SyntaxTriviaRuleClass.class).language().toLowerCase().equals(this.language)) {
                    try {
                        this.syntaxTriviaRules.add((SyntaxTriviaRule) (c.newInstance()));
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private Set<SyntaxTriviaRule> getSyntaxTriviaRules() {
        return this.syntaxTriviaRules;
    }

    public List<? extends SyntaxUnit> updateSyntaxTokenStream(List<SyntaxToken> tokenList) {
        ArrayList<SyntaxUnit> result = new ArrayList<>();
        for (SyntaxToken token : tokenList) {
            if (currentApplyingRule == null) {
                Optional<SyntaxTriviaRule> candidateRule = this.getSyntaxTriviaRules().stream().filter(rule -> rule.getTrigger().equals(token.getRawString())).findFirst();
                candidateRule.ifPresent(rule -> {
                    this.currentApplyingRule = rule;
                    this.currentSyntaxTrivia = new SyntaxTrivia(token.getStart());
                    this.currentSyntaxTrivia.addChildToken(token);
                });
            }
            if (currentApplyingRule != null) {
                if (currentApplyingRule.getTerminator().equals(token.getRawString())) {
                    if (currentApplyingRule.isPartOfTrivia()) {
                        this.currentSyntaxTrivia.addChildToken(token);
                    }
                    result.add(this.currentSyntaxTrivia);
                }
            }
        }
        return result;
    }
}
