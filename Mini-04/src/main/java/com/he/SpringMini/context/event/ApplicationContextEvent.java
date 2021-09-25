package com.he.SpringMini.context.event;

import com.he.SpringMini.context.ApplicationContext;
import com.he.SpringMini.context.ApplicationEvent;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 8:40 下午
 * @Version 1.0
 *
 */

/**
 * 应用上下文事件， 事件的抽象类，
 * 所有的事件 包括 事件的关闭， 刷新，以及用户自己实现的事件，都需要继承这个类
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 拿到 应用上下文
     * @return
     */
    public final ApplicationContext getApplicationContext(){
        return (ApplicationContext) getSource();
    }
}
