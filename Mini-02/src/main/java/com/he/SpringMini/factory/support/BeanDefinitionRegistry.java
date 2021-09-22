package com.he.SpringMini.factory.support;

import com.he.SpringMini.factory.config.BeanDefinition;

/**
 * 定义 beanDefinition的注册接口
 */
public interface BeanDefinitionRegistry {
    BeanDefinition registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
