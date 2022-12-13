package effective.java.item27.ch2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.CLASS)
//@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE,ElementType.METHOD}) //어디다가만 붙이게 할거냐?
public @interface MyAnnotation {
}
