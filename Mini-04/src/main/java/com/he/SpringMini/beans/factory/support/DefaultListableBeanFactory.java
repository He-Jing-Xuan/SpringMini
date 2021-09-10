package com.he.SpringMini.beans.factory.support;


import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null)
            throw new BeanException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeanException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public BeanDefinition registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        return beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }



    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
       Map<String,T> result = new HashMap<>();
       beanDefinitionMap.forEach((beanName,beanDefinition)->{
           Class beanClass = beanDefinition.getBeanClass();
           if(type.isAssignableFrom(beanClass)){
               result.put(beanName,(T)getBean(beanName));
           }
       });
       return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
