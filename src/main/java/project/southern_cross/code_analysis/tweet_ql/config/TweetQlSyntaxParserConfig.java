package project.southern_cross.code_analysis.tweet_ql.config;

import project.southern_cross.code_analysis.core.annotation.SyntaxParserConfigClass;
import project.southern_cross.code_analysis.core.config.SyntaxParserConfig;

import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
@SyntaxParserConfigClass(language = "tweet_ql")
public class TweetQlSyntaxParserConfig implements SyntaxParserConfig {
    @Override
    public int getInitialState() {
        return 0;
    }

    @Override
    public List<Integer> getStates() {
        return null;
    }
}
