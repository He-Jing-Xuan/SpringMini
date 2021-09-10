package com.he.SpringMini.beans.factory;

import com.he.SpringMini.beans.BeanException;

import java.util.Map;

/**
 * @Author tal
 * @Date 2021/9/6 5:26 下午
 * @Version 1.0
 */
public interface ListabelBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeanException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;
    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
