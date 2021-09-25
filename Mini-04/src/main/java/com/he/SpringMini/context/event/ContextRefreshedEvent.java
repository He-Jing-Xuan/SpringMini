package com.he.SpringMini.context.event;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 8:47 下午
 * @Version 1.0
 *  定义了 容器的刷新事件
 */

public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
