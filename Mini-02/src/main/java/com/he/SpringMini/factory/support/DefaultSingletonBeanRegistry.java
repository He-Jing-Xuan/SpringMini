package com.he.SpringMini.factory.support;

import com.he.SpringMini.factory.config.SingletonBeanRegistry;


import java.util.HashMap;
import java.util.Map;

/**
 * 默认的bean 的注册 与获取 的类
 * 使用一个hashmap 保存对应的 bean对象
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singleObejcts = new HashMap<String, Object>();


    @Override
    public Object getSingleton(String beanName) {
        return singleObejcts.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singleObejcts.put(beanName, singletonObject);
    }
}
