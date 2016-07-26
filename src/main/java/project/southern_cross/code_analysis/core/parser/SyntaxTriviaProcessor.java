package project.southern_cross.code_analysis.core.parser;

import project.southern_cross.code_analysis.core.SyntaxToken;
import project.southern_cross.code_analysis.core.SyntaxTrivia;
import project.southern_cross.code_analysis.core.SyntaxUnit;
import project.southern_cross.code_analysis.core.boot.BootLoader;
import project.southern_cross.code_analysis.core.config.SyntaxTriviaConfig;
import project.southern_cross.code_analysis.core.config.SyntaxTriviaRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    private SyntaxTriviaConfig getSyntaxTriviaConfig() {
        return BootLoader.getTriviaConfig(this.language);
    }

    private Set<SyntaxTriviaRule> getSyntaxTriviaRules() {
        return this.getSyntaxTriviaConfig().getSyntaxTriviaRules();
    }

    public List<SyntaxUnit> updateSyntaxTokenStream(List<SyntaxToken> tokenList) {
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
