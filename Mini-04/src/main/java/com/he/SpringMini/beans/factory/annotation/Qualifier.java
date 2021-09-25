package com.he.SpringMini.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 9:51 下午
 * @Version 1.0
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
