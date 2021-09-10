package com.he.SpringMini.aop.framework.adapter;

import com.he.SpringMini.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 9:58 下午
 * @Version 1.0
 * 方法拦截器
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {
    public MethodBeforeAdvice advice;
    // 最开始 没有无参数的构造函数 而报属性Error setting property values：pointcutAdvisor
    public MethodBeforeAdviceInterceptor(){}
    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice){
        this.advice = advice;
    }
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.advice.before(methodInvocation.getMethod(),methodInvocation.getArguments(),methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
