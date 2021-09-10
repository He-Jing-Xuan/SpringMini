package com.he.SpringMini.context.annotation;

import java.lang.annotation.*;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 10:53 上午
 * @Version 1.0
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
