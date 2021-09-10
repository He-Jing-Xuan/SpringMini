package com.he.SpringMini.beans.factory.config;

/**
 * 单列 注册接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}

