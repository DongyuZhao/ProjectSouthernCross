package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 * <p>
 * Created by Dy.Zhao on 2016/9/2.
 */

/**
 * The class that hold syntax errors found by the lexer and the syntax parser.
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

    /**
     * Generate an instance that indicates there is no error
     * @return the instance that indicates there is no error
     */
    public static SyntaxError getNoError() {
        return new SyntaxError("", false, false);
    }

    /**
     * Generate an instance that indicates the given syntax token is missing
     * @param token the given syntax token
     * @return the instance that indicates the given syntax token is missing
     */
    public static SyntaxError getMissingError(SyntaxToken token) {
        return getMissingError(token.getRawString());
    }

    /**
     * Generate an instance that indicates the given syntax token is missing
     * @param tokenString the full string of given syntax token
     * @return the instance that indicates the given syntax token is missing
     */
    public static SyntaxError getMissingError(String tokenString) {
        return new SyntaxError(tokenString + " is missing.", true, false);
    }

    /**
     * Generate an instance that indicates the given syntax token is unexpected
     * @param token the given syntax token
     * @return the instance that indicates the given syntax token is unexpected
     */
    public static SyntaxError getUnexpectedError(SyntaxToken token) {
        return getUnexpectedError(token.getRawString());
    }

    /**
     * Generate an instance that indicates the given syntax token is unexpected
     * @param tokenString the full string of given syntax token
     * @return the instance that indicates the given syntax token is unexpected
     */
    public static SyntaxError getUnexpectedError(String tokenString) {
        return new SyntaxError(tokenString + " is unexpected.", false, true);
    }

    /**
     * Get if this instance indicates error
     * @return if this instance indicates error
     */
    public boolean isError() {
        return this.isMissing() || this.isUnexpected();
    }

    /**
     * Get if this instance indicates missing error
     * @return if this instance indicates missing error
     */
    public boolean isMissing() {
        return missing;
    }

    /**
     * Get if this instance indicates unexpected error
     * @return if this instance indicates unexpected error
     */
    public boolean isUnexpected() {
        return unexpected;
    }

    /**
     * Set if this instance indicates unexpected error
     * @param unexpected if this instance indicates unexpected error
     */
    public void setUnexpected(boolean unexpected) {
        this.unexpected = unexpected;
    }

    /**
     * Set if this instance indicates missing error
     * @param missing if this instance indicates missing error
     */
    public void setMissing(boolean missing) {
        this.missing = missing;
    }

    /**
     * Get the error message this instance hold
     * @return the error message this instance hold
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Set the error message this instance hold
     * @param errorMessage the error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
