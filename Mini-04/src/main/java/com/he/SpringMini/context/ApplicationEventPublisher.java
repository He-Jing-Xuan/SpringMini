package com.he.SpringMini.context;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 9:13 下午
 * @Version 1.0
 */
public interface ApplicationEventPublisher {
    /**
     * 定义事件的发布
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
