package project.southern_cross.code_analysis.core.boot;


import project.southern_cross.code_analysis.core.config.SyntaxFacts;
import project.southern_cross.code_analysis.core.config.SyntaxParserConfig;
import project.southern_cross.code_analysis.core.config.SyntaxTriviaConfig;

import java.util.HashMap;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/26.
 */
public class BootLoader {

    private static HashMap<String, SyntaxParserConfig> parserConfigs = new HashMap<>();
    private static HashMap<String, SyntaxFacts> syntaxFacts = new HashMap<>();
    private static HashMap<String, SyntaxTriviaConfig> triviaConfigs = new HashMap<>();

    public static SyntaxParserConfig getParserConfig(String language) {
        return parserConfigs.get(language);
    }

    public static SyntaxFacts getSyntaxFacts(String language) {
        return syntaxFacts.get(language);
    }

    public static SyntaxTriviaConfig getTriviaConfig(String language) {
        return triviaConfigs.get(language);
    }
}
