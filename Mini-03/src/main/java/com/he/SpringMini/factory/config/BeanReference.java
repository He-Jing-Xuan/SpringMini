package com.he.SpringMini.factory.config;

/**
 * @Author tal
 * @Date 2021/9/5 4:41 下午
 * @Version 1.0
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
