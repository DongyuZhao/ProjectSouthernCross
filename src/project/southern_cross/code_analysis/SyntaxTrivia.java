package project.southern_cross.code_analysis;

import java.util.Optional;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxTrivia {
    private Optional<Span> _span = Optional.of(new Span());
    private String _rawString;

    public Optional<Span> span() {
        return _span;
    }

    public String rawString() {
        return _rawString;
    }
}
