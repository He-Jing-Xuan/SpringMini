package com.he.SpringMini.factory.support;

import com.he.SpringMini.BeanException;
import com.he.SpringMini.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;

/**
 * 创建bean  并加入到缓存中
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("Instantiation of bean failed", e);
        }
        // 加入到缓存中
        addSingleton(beanName, bean);
        return bean;
    }
}
