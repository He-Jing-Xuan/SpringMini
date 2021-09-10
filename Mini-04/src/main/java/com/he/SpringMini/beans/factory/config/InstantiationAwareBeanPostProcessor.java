package com.he.SpringMini.beans.factory.config;

import com.he.SpringMini.beans.BeanException;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/9 11:03 下午
 * @Version 1.0
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{
    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     *
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeanException;
}
