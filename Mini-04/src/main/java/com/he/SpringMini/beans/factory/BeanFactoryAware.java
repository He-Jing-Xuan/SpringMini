package com.he.SpringMini.beans.factory;

import com.he.SpringMini.beans.BeanException;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/8 9:41 上午
 * @Version 1.0
 * 实现此接口，既能感知到所属的 BeanFactory
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeanException;
}
