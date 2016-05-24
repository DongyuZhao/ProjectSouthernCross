package project.southern_cross.code_analysis;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class SemanticModel {
    public ArrayList<SyntaxTree> _syntaxTree;

    public SyntaxTree getSyntaxTree(String filePath) {
        Optional<SyntaxTree> result = this._syntaxTree.stream().filter(
                syntaxTree -> syntaxTree.filePath().equals(filePath)
        ).findFirst();
        if ( result.isPresent())
        {
            return result.get();
        }
        return null;
    }
}
