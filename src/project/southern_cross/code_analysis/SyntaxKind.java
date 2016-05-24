package project.southern_cross.code_analysis;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/5/11 0011.
 */
public class SyntaxKind {
    public final static int Undetermined = -1;
    public final static int ReservedKeyword = 0;
    public final static int PredefinedType = 1000;
    public final static int UserDefinedType = 2000;
    public final static int ReservedOperator = 3000;
    public final static int Root = 9999;
}
