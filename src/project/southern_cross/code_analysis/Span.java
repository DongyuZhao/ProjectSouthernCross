package project.southern_cross.code_analysis;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class Span {
    private int _start = -1;
    private int _end = -1;

    public int start() {
        return _start;
    }

    public int end() {
        return _end;
    }

    public Span() {

    }

    public Span(int start, int end) {
        this._start = start;
        this._end = end;
    }
}
