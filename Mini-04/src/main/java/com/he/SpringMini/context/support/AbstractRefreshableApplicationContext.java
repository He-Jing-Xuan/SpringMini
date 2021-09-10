package com.he.SpringMini.context.support;

import com.he.SpringMini.beans.BeanException;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;
import com.he.SpringMini.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author tal
 * @Date 2021/9/6 11:12 下午
 * @Version 1.0
 * 获取beang工厂和加载资源
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory ;


    @Override
    protected void refreshBeanFactory() throws BeanException {
        // 创建bean工厂
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 加载 beanDifinition
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 符合类设计， 定义抽象的加载资源类， 具体实现 又 子类实现
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
