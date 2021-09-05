package beantest;

import com.he.SpringMini.BeanDefinition;
import com.he.SpringMini.BeanFactory;

public class testBeanFactory {
    public static void main(String[] args) {
        test_BeanFactory();
    }
    public static void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
