package event;

import com.he.SpringMini.context.ApplicationListener;

import java.util.Date;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 10:41 上午
 * @Version 1.0
 */
// 事件的监听者，  监听的事件就是 CustomEvent
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());

    }
}
