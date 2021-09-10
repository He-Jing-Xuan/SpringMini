package com.he.SpringMini.beans.factory.support;


import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.factory.ConfigurableBeanFactory;
import com.he.SpringMini.beans.factory.FactoryBean;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBeanFactory 继承了父类的 单列bean的获取方法getSingleton。
 * 实现BeanFactory 的getBean的方法。来获取单列。
 * 修改：AbstractBeanFactory 原来 继承 DefaultSingletonBeanRegistry 。
 * 现在修改成 FactoryBeanRegistrySupport  因为 FactoryBeanRegistrySupport  继承了 DefaultSingletonBeanRegistry， 实现了 FactoryBean的扩展
 *
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) throws BeanException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return  (T)getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance,name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);

        Object bean = createBean(name,beanDefinition,args);
        return (T) getObjectForBeanInstance(bean,name);
    }

    // 定义 抽象的 方法， 具体实现由子类实现
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    /**
     * 获取bean对象； 普通的bean  和factoryBean
     * @param beanInstance
     * @param beanName
     * @return
     */
    private Object getObjectForBeanInstance(Object beanInstance,String beanName){
        if(!(beanInstance instanceof FactoryBean))
            return beanInstance;
        Object object = getCachedObjectForFactoryBean(beanName);
        if(object == null){
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean,beanName);
        }
        return  object;
    }
}
