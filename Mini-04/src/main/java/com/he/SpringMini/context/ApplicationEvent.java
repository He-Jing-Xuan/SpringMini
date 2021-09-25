package com.he.SpringMini.context;

import java.util.EventObject;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 8:38 下午
 * @Version 1.0
 * 定义具备 事件功能的 抽象类
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
