package com.he.SpringMini.factory.support;

import com.he.SpringMini.BeanException;
import com.he.SpringMini.factory.config.BeanDefinition;



import java.util.HashMap;
import java.util.Map;

/**
 * DefaultListableBeanFactory 使用一个map 存了 beanDefinition即=即bean的定义相关的东西。
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String,BeanDefinition>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeanException {

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeanException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public BeanDefinition registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        return beanDefinitionMap.put(beanName, beanDefinition);
    }
}
