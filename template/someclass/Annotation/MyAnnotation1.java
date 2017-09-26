package someclass.Annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.TYPE, ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    String name() default "MyAnnotation1";
    int age() default 10;
}
