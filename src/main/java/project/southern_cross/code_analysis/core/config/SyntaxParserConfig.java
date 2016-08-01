package project.southern_cross.code_analysis.core.config;

import java.util.List;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/25.
 */
public interface SyntaxParserConfig {

    int getInitialState();

    List<Integer> getStates();
}
