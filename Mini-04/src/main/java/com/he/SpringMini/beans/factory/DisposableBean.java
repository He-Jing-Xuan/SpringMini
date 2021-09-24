package com.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/7 4:47 下午
 * @Version 1.0
 * 定义 bean销毁的接口， 如果bean实现了该接口，就会在适当的时期销毁bean
 */
public interface DisposableBean {
    /**
     * bean的销毁
     */
    void destroy() throws Exception;
}
