package com.he.SpringMini.factory.support;

import com.he.SpringMini.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    BeanDefinition registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
