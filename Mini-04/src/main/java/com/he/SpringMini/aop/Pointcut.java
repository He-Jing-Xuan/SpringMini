package com.he.SpringMini.aop;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 11:05 上午
 * @Version 1.0
 * 切点表达
 */
public interface Pointcut {
    /**
     * 获取类过滤器
     * @return
     */
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
