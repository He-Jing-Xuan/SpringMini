package com.he.SpringMini.context.event;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 8:42 下午
 * @Version 1.0
 * 定义容器关闭事件
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }

}
