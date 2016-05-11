package project.southern_cross.code_analysis;

import project.southern_cross.general.NullableValue;

import java.util.ArrayList;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxToken {
    private NullableValue<Span> _span = new NullableValue<>();
    private NullableValue<Span> _fullSpan = new NullableValue<>();

    private ArrayList<SyntaxNode> _childNodes = new ArrayList<>();
    private ArrayList<SyntaxToken> _childTokens = new ArrayList<>();

    private SyntaxKind _kind;

    private String _rawString;

    public SyntaxToken(String rawString, int spanStart, int spanEnd, int fullSpanStart, int fullSpanEnd, SyntaxKind kind) {
        this._span.setValue(new Span(spanStart, spanEnd));
        this._fullSpan.setValue(new Span(fullSpanStart, fullSpanEnd));
        this._kind = kind;
        this._rawString = rawString;
    }
}
