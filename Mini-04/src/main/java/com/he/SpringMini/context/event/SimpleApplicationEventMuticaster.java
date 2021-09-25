package com.he.SpringMini.context.event;

import com.he.SpringMini.beans.factory.BeanFactory;
import com.he.SpringMini.context.ApplicationEvent;
import com.he.SpringMini.context.ApplicationListener;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/24 9:18 下午
 * @Version 1.0
 */
public class SimpleApplicationEventMuticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMuticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }
    // 让监听者接收到 事件的发布
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
