package event;

import com.he.SpringMini.context.ApplicationListener;
import com.he.SpringMini.context.event.ContextClosedEvent;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 10:45 上午
 * @Version 1.0
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
