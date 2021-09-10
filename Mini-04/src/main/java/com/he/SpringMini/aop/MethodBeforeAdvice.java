package com.he.SpringMini.aop;

import java.lang.reflect.Method;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 10:00 下午
 * @Version 1.0
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method method, Object[] args , Object target) throws Throwable;
}
