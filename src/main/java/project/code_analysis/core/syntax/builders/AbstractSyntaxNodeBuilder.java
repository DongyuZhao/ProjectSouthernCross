package project.code_analysis.core.syntax.builders;

import project.code_analysis.core.SyntaxNode;
import project.code_analysis.core.SyntaxToken;

import java.util.ArrayList;

/**
 * This is a open source project provided as-is without any
 * guarantee.
 *
 * Created by Dy.Zhao on 2016/8/23.
 */
public abstract class AbstractSyntaxNodeBuilder<T extends SyntaxNode> {
    protected T root;

    protected ArrayList<SyntaxToken> tokenList = new ArrayList<>();

    public void append(SyntaxToken token) {
        this.tokenList.add(token);
    }

    public void clear() {
        this.tokenList.clear();
    }

    public abstract T build();
}
