package com.he.SpringMini.beans.factory;

/**
 * @Author tal
 * @Date 2021/9/8 9:43 上午
 * @Version 1.0
 *
 */
public interface BeanClassLoaderAware extends Aware{
   // 实现此接口，既能感知到所属的 ClassLoader
    void setBeanClassLoader(ClassLoader classLoader);
}
