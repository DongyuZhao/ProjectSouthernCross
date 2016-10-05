package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/25.
 */

/**
 * A class that hold the span information
 */
public class SyntaxSpan {
    private int start;
    private int end;

    /**
     * Get a new instance of the SyntaxSpan class
     * @param start the start position
     * @param end the end position
     */
    public SyntaxSpan(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Get the start position
     * @return the start position
     */
    public int getStart() {
        return start;
    }

    /**
     * Get the end position
     * @return the end position
     */
    public int getEnd() {
        return end;
    }

    /**
     * Determine if this span is overlap with the given span
     * @param span the given span
     * @return if this span is overlap with the given span
     */
    public boolean isOverlapWith(SyntaxSpan span) {
        return !(this.end <= span.start) && !(this.start >= span.end);
    }
}
