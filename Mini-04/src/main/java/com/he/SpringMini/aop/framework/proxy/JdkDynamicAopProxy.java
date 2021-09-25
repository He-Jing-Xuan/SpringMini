package com.he.SpringMini.aop.framework.proxy;

import com.he.SpringMini.aop.AdvisedSupport;
import com.he.SpringMini.aop.framework.ReflectiveMethodInvocation;
import com.he.SpringMini.aop.framework.proxy.AopProxy;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author tal
 * @Date 2021/9/9 10:55 上午
 * @Version 1.0
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport support){
        this.advised = support;
    }
    // 获取代理对象
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),advised.getTargetSource().getTargetClass(),this);
    }
    //执行代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(advised.getMethodMatcher().matches(method,advised.getTargetSource().getClass().getClass())){
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
           return  methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
        }
        return method.invoke(advised.getTargetSource().getTarget(),args);
    }
}
