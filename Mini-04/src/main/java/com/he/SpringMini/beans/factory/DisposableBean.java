package com.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/7 4:47 下午
 * @Version 1.0
 */
public interface DisposableBean {
    /**
     * bean的销毁
     */
    void destroy() throws Exception;
}
