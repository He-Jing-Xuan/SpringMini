package com.he.SpringMini.context;

import java.util.EventListener;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 8:57 下午
 * @Version 1.0
 */
public interface ApplicationListener<E extends  ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);

}
