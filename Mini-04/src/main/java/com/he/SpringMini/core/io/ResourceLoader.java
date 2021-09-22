package com.he.SpringMini.core.io;

/**
 * @Author tal
 * @Date 2021/9/6 4:42 下午
 * @Version 1.0
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     * 定义路径前缀
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
