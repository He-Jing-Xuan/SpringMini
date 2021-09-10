package com.he.SpringMini.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @Author tal
 * @Date 2021/9/9 10:55 上午
 * @Version 1.0
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    protected final Object target;

    protected final Method method;

    protected final Object[] argments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.argments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return argments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, argments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }


}
