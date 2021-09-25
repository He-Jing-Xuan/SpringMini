package aotuwired;


import com.he.SpringMini.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/25 2:08 下午
 * @Version 1.0
 */
public class ttt {
    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-aotuwired.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
