package task1;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyTest {
    int a() default 0;
    int b() default 0;
}
