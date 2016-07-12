package project.southern_cross.code_analysis_v2;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/11.
 */
public class SyntaxKind {
    public final static int UnDetermined = 0;
    public final static int ReservedKeyword = 1;
    public final static int PredefinedType = 1001;
    public final static int UserDefinedType = 2001;
    public final static int ReservedOperator = 3001;
    public final static int Root = 9999;
}
