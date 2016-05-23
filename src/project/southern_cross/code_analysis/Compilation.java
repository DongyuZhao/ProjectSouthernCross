package project.southern_cross.code_analysis;

/**
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public abstract class Compilation {
    private SemanticModel _semanticModel;

    public SemanticModel getSemanticModel() {
        return this._semanticModel;
    }

    public SyntaxTree getSyntaxTree(String filePath) {
        if (filePath != null) {
            if (this._semanticModel != null) {
                return this._semanticModel.getSyntaxTree(filePath);
            }
            throw new NullPointerException("SemanticModel is Null.");
        }
        throw new NullPointerException("File path is null");
    }
}