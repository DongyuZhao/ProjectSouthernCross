package project.southern_cross.code_analysis.annotations;

import project.southern_cross.code_analysis.SyntaxKind;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 *
 * Created by Dy.Zhao on 2016/7/11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SyntaxRule {
    String language() default "Default";
    int contextSyntaxKind() default SyntaxKind.Root;
}
