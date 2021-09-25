package event;

import com.he.SpringMini.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 10:50 上午
 * @Version 1.0
 */
public class EvetnTest {
    @Test
    public void test_event() {
        // 加载配置文件时， 将 三个事件的监听者 加入到容器之中。
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springEvent.xml");
       // 当发布事件时， 监听者收到消息。
        applicationContext.publishEvent(new CustomEvent(applicationContext, 11, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
