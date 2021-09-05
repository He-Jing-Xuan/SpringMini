package com.he.SpringMini.factory.support;

import com.he.SpringMini.BeanException;
import com.he.SpringMini.factory.BeanFactory;
import com.he.SpringMini.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;

/**
 * AbstractBeanFactory 继承了父类的 单列bean的获取方法getSingleton。
 * 实现BeanFactory 的getBean的方法。来获取单列。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = getSingleton(name);
        if(bean != null){
            return bean;
        }
        //如果bean为空 就创建bean
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }
    // 定义 抽象的 方法， 具体实现由子类实现
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
