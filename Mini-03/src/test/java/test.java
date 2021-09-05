import com.he.SpringMini.factory.config.BeanDefinition;
import com.he.SpringMini.factory.support.DefaultListableBeanFactory;

/**
 * @Author he-jing-xuan
 * @Date 2021/9/5 4:23 下午
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
// 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(User.class);
        beanFactory.registerBeanDefinition("user", beanDefinition);

        // 3.获取bean
        User userService = (User) beanFactory.getBean("user", "小");
        userService.queryUserInfo();
    }
}
