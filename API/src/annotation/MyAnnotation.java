package annotation;

import java.awt.*;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {

    public String name() default "lili";
    public String[] like();
    public Color color();
}
