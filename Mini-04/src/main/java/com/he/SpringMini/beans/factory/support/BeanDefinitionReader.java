package com.he.SpringMini.beans.factory.support;

import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.core.io.Resource;
import com.he.SpringMini.core.io.ResourceLoader;

/**
 * @Author tal
 * @Date 2021/9/6 4:46 下午
 * @Version 1.0
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;

    void loadBeanDefinitions(String [] location) throws BeanException;
}
