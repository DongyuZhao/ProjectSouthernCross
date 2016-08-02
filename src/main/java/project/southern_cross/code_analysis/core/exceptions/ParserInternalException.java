package project.southern_cross.code_analysis.core.exceptions;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/8/2.
 */
public class ParserInternalException extends Throwable {
    public ParserInternalException() {
    }

    public ParserInternalException(String message) {
        super(message);
    }

    public ParserInternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserInternalException(Throwable cause) {
        super(cause);
    }

    public ParserInternalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
