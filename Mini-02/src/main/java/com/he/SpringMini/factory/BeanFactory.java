package com.he.SpringMini.factory;

import com.he.SpringMini.BeanException;

/**
 * 定义获取bean的接口
 */
public interface BeanFactory {
    Object getBean(String name) throws BeanException;
}
