package project.code_analysis.core;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/25.
 */
public class SyntaxSpan {
    private int start;
    private int end;

    public SyntaxSpan(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isOverlapWith(SyntaxSpan span) {
        return !(this.end <= span.start) && !(this.start >= span.end);
    }
}
