package com.he.SpringMini.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 9:52 下午
 * @Version 1.0
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    String value() default "";
}
