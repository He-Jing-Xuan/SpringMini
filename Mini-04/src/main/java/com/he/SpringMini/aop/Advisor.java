package com.he.SpringMini.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 9:59 下午
 * @Version 1.0
 */
public interface Advisor {
    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
