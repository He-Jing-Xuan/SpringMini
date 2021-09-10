package com.he.SpringMini.core.io;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author tal
 * @Date 2021/9/6 4:33 下午
 * @Version 1.0
 */
public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : Thread.currentThread().getContextClassLoader());
    }

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    @Override
    public InputStream getInputStream() throws IOException {
       InputStream is = classLoader.getResourceAsStream(path);
       if(is == null ){
           throw  new FileNotFoundException(this.path + "没有找到资源");
       }
       return is;
    }
}
