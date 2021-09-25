package com.he.SpringMini.aop.framework.proxy;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 10:54 上午
 * @Version 1.0
 * 定义AOP代理接口，具体实现交给JDK和Cglib
 */
public interface AopProxy {
    Object getProxy();
}
