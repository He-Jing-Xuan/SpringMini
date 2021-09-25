package event;

import com.he.SpringMini.context.ApplicationListener;
import com.he.SpringMini.context.event.ContextRefreshedEvent;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 10:49 上午
 * @Version 1.0
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());

    }
}
