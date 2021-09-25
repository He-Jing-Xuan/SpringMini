package com.he.SpringMini.context.event;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 8:52 下午
 * @Version 1.0
 */

import com.he.SpringMini.context.ApplicationEvent;
import com.he.SpringMini.context.ApplicationListener;

/**
 * 定义事件的广播器
 */
public interface ApplicationEventMulticaster {

    /**
     * 增加事件监听者
     */
    void addApplicationListener(ApplicationListener<?> listener );

    void  removeApplicationListenr(ApplicationListener<?> listener);

    /**
     * 事件广播
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
