package com.he.SpringMini.factory.support;

import com.he.SpringMini.BeanException;
import com.he.SpringMini.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 自定义策略接口
 */
public interface InstantiationStrategy {
    /**
     * 构造 有参bean时的必要信息
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeanException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;
}
