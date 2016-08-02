package project.southern_cross.code_analysis.core;

import project.southern_cross.code_analysis.core.exceptions.UnsupportedLanguageException;
import project.southern_cross.code_analysis.core.parser.SyntaxParser;

import java.util.concurrent.TimeoutException;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/16.
 */
public class SyntaxTree {

    public static ParsedSyntaxTree parse(String source, String language) throws TimeoutException, UnsupportedLanguageException {
        try {
            SyntaxParser parser = SyntaxParser.createParser(language);
            if (parser != null) {
                return new ParsedSyntaxTree(parser.parse(source));
            }
        } catch (TimeoutException | UnsupportedLanguageException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }
}
