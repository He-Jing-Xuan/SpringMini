package com.he.SpringMini.beans.factory.support;

import com.he.SpringMini.core.io.DefaultResourceLoader;
import com.he.SpringMini.core.io.ResourceLoader;

/**
 * @Author tal
 * @Date 2021/9/6 4:54 下午
 * @Version 1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
     private final BeanDefinitionRegistry registry;

     private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
