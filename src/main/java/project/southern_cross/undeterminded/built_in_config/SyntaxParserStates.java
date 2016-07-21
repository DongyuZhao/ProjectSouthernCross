package project.southern_cross.undeterminded.built_in_config;


import project.southern_cross.undeterminded.annotations.SyntaxParseState;
import project.southern_cross.undeterminded.annotations.SyntaxParserConfig;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/14.
 */
@SyntaxParserConfig(language = "All")
public class SyntaxParserStates {
    @SyntaxParseState
    public final static int Terminate = 0;

    @SyntaxParseState
    public final static int ROOT = 1;

    @SyntaxParseState
    public final static int COMMENT = 2;
}
