package com.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/8 9:45 上午
 * @Version 1.0
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
