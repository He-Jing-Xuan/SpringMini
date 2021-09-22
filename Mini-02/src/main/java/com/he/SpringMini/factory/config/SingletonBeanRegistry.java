package com.he.SpringMini.factory.config;

/**
 * 单列 bean的注册接口
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}

