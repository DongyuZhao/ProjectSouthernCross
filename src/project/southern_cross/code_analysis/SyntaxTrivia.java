package project.southern_cross.code_analysis;

import java.util.Optional;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxTrivia {
    private Span _span = new Span();
    private String _rawString;

    public SyntaxTrivia(String rawString, int spanStart, int spanEnd) {
        this._rawString = rawString;
        this._span = new Span(spanStart, spanEnd);
    }

    public Span span() {
        return _span;
    }

    public String rawString() {
        return _rawString;
    }


}
