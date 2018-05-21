package someclass.Annotation;

import java.lang.annotation.Inherited;

@Inherited
public @interface MyAnnotation2 {
    String name() default "MyAnnotation2";
    int age() default 20;
}
