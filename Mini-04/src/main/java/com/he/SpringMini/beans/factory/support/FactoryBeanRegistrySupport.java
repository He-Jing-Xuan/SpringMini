package com.he.SpringMini.beans.factory.support;

import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/8 10:53 上午
 * @Version 1.0
 * 用于注册factoryBean
 *
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String ,Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory , String beanName){
        if(factory.isSingleton()){
            Object object = this.factoryBeanObjectCache.get(beanName);
            if(object == null){
                object = doGetObjectFromFactoryBean(factory,beanName);
                this.factoryBeanObjectCache.put(beanName,(object != null ? object : NULL_OBJECT));
            }
            return object!=NULL_OBJECT ? object: null;
        }else
            return doGetObjectFromFactoryBean(factory,beanName);
    }

    /**
     *
     * @param factory
     * @param beanName
     * @return
     */
    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeanException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
