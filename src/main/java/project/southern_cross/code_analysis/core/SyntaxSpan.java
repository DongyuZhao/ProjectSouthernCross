package project.southern_cross.code_analysis.core;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
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

    public void setStart(int start) {
        if (start < 0) {
            throw new IllegalArgumentException("The final start should not be less than 0.");
        }
        if (start > this.end) {
            throw new IllegalArgumentException("The final start should not be more than end.");
        }
        this.start = start;
    }

    public void setStart(int start, boolean forceUpdate) {
        if (forceUpdate) {
            this.start = start;
        } else {
            this.setStart(start);
        }
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        if (end < 0) {
            throw new IllegalArgumentException("The final end should not be less than 0.");
        }
        if (end < this.start) {
            throw new IllegalArgumentException("The final end should not be less than start.");
        }
        this.end = end;
    }

    public void setEnd(int end, boolean forceUpdate) {
        if (forceUpdate) {
            this.end = end;
        } else {
            this.setEnd(end);
        }
    }

    public void shiftWindow(int offset) {
        if (offset >= 0) {
            this.setEnd(this.end + offset, true);
            this.setStart(this.start + offset, true);
        } else {
            this.setStart(this.start + offset, true);
            this.setEnd(this.end + offset, true);
        }
    }
}
