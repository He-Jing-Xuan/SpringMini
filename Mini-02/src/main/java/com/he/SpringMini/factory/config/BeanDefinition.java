package com.he.SpringMini.factory.config;

/**
 * bean的定义
 */
public class BeanDefinition {
    private Class beanClass;
    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }
   public Class getBeanClass(){
        return beanClass;
    }
}
