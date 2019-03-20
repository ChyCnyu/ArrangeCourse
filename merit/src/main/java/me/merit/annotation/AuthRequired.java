package me.merit.annotation;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthRequired {
}
