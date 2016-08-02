package project.southern_cross.code_analysis.core.annotation;

import org.atteo.classindex.IndexAnnotated;
import project.southern_cross.code_analysis.core.SyntaxKind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/27.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@IndexAnnotated
public @interface SyntaxParseRuleClass {
    String language() default "all";

    int[] prerequisiteStates() default {SyntaxKind.ROOT};
}
