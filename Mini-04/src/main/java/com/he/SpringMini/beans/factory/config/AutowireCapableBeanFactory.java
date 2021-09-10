package com.he.SpringMini.beans.factory.config;

import com.he.SpringMini.beans.BeanException;


/**
 * @Author tal
 * @Date 2021/9/6 5:30 下午
 * @Version 1.0
 */
public interface AutowireCapableBeanFactory {

    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeanException;

    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeanException;

}
