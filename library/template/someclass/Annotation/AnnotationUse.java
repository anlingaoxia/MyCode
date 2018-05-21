package someclass.Annotation;

import java.lang.annotation.Annotation;

public class AnnotationUse {

    public static void main(String[] args) {
        Test test = new Test();
        try {
            Annotation[] array = Class.forName("someclass.Annotation.Test").getMethod("print2").getAnnotations();
            for (Annotation an : array) {
                System.out.println(an);
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}