package com.he.SpringMini.context.support;

import com.he.SpringMini.beans.factory.support.DefaultListableBeanFactory;
import com.he.SpringMini.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author tal
 * @Date 2021/9/6 11:21 下午
 * @Version 1.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    /**
     * 加载beanDefinition
     * @param beanFactory
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String [] configLocations = getConfigLocations();
        if(configLocations != null){
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }
    protected abstract String[] getConfigLocations();
}
