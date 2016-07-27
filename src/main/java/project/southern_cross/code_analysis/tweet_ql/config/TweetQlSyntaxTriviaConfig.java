package project.southern_cross.code_analysis.tweet_ql.config;

import project.southern_cross.code_analysis.core.annotation.SyntaxTriviaConfigClass;
import project.southern_cross.code_analysis.core.config.SyntaxTriviaConfig;
import project.southern_cross.code_analysis.core.config.SyntaxTriviaRule;

import java.util.Set;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
@SyntaxTriviaConfigClass(language = "tweet_ql")
public class TweetQlSyntaxTriviaConfig implements SyntaxTriviaConfig {
    @Override
    public Set<SyntaxTriviaRule> getSyntaxTriviaRules() {
        return null;
    }
}
