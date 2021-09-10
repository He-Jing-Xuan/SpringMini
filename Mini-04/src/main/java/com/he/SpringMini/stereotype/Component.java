package com.he.SpringMini.stereotype;

import java.lang.annotation.*;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/10 10:55 上午
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
