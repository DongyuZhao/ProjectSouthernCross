package project.southern_cross.undeterminded.annotations;

//import org.atteo.classindex.IndexAnnotated;

import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project Southern Cross
 * A language parser framework come up with TweetQL parser. Originally designed for R.A.P.I.D
 * <p>
 * Created by Dy.Zhao on 2016/7/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@IndexAnnotated
public @interface SyntaxParseState {
}
