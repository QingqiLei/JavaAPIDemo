package annotation;

import java.lang.annotation.*;

// 用于生成文档
@Documented
// 表示该注解的作用范围在运行时存在
@Retention(RetentionPolicy.RUNTIME)
// 用于表示注解的应用范围（类，方法，属性，构造器，局部变量，包。Annotation）
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    public String name() default "lili";
    public String[] like();

    public Color color();


}

