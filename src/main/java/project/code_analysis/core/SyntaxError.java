package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/2.
 */
public class SyntaxError {
    private boolean missing;
    private boolean unexpected;
    private String errorMessage;

    public SyntaxError(String errorMessage) {
        this.errorMessage = errorMessage;
        this.missing = true;
        this.unexpected = true;
    }

    public SyntaxError(String errorMessage, boolean missing, boolean unexpected) {
        this.missing = missing;
        this.unexpected = unexpected;
        this.errorMessage = errorMessage;
    }

    public static SyntaxError getNoError() {
        return new SyntaxError("", false, false);
    }

    public static SyntaxError getMissingError(SyntaxToken token) {
        return getMissingError(token.getRawString());
    }

    public static SyntaxError getMissingError(String tokenString) {
        return new SyntaxError(tokenString + " is missing.", true, false);
    }

    public static SyntaxError getUnexpectedError(SyntaxToken token) {
        return getUnexpectedError(token.getRawString());
    }

    public static SyntaxError getUnexpectedError(String tokenString) {
        return new SyntaxError(tokenString + " is unexpected.", false, true);
    }

    public boolean isError() {
        return this.isMissing() || this.isUnexpected();
    }

    public boolean isMissing() {
        return missing;
    }

    public boolean isUnexpected() {
        return unexpected;
    }

    public void setUnexpected(boolean unexpected) {
        this.unexpected = unexpected;
    }

    public void setMissing(boolean missing) {
        this.missing = missing;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
