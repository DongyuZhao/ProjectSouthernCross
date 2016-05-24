package project.southern_cross.code_analysis;

import java.util.Optional;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxTrivia {
    private Span span = new Span();
    private String rawString;

    public SyntaxTrivia(String rawString, int spanStart, int spanEnd) {
        this.rawString = rawString;
        this.span = new Span(spanStart, spanEnd);
    }

    public Span span() {
        return span;
    }

    public String rawString() {
        return rawString;
    }


}
