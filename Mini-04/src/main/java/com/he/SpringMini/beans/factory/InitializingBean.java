package com.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/7 4:43 下午
 * @Version 1.0
 * InitializingBean、DisposableBean，两个接口方法还是比较常用的，
 * 在一些需要结合 Spring 实现的组件中，经常会使用这两个方法来做一些参数的初始化和销毁操作。
 * 比如接口暴漏、数据库数据读取、配置文件加载等等
 */
public interface InitializingBean {
    /**
     * bean的初始化，在加载配置文件之后。
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
