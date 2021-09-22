package com.he.SpringMini.factory.support;

import com.he.SpringMini.BeanException;
import com.he.SpringMini.factory.BeanFactory;
import com.he.SpringMini.factory.config.BeanDefinition;


/**
 * AbstractBeanFactory 继承了父类的 单列bean的获取方法getSingleton。
 * 实现BeanFactory 的getBean的方法。来获取单列。
 * 1。 实现了BeanFactory接口的getBean方法。 而真正的获取来自DefaultSingletonBeanRegistry 中的map
 * 通过对BeanFactory的实现和DefaultSingletonBeanRegistry 继承，
 * 让AbstractBeanFactory拥有了 bean的注册与获取的能力。
 *
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeanException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        //如果bean为空 就创建bean
        //抽象的getBeanDefinition 方法，  由 DefaultListableBeanFactory 具体实现，
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 根据 beanName 和 beanDefinition 来创建具体的 bean对象。
        // createBean 由 AbstractBeanFactory的子类 AbstractAutowireCapableBeanFactory 实现
        // 通过反射 创建bean  并且 通过addSingleton（） 加入到DefaultSingletonBeanRegistry 的map中。
        return createBean(name, beanDefinition);
    }

    // 定义 抽象的 方法， 具体实现由子类实现
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException;
}
