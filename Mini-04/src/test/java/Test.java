import con.he.SpringMini.beans.factory.support.DefaultListableBeanFactory;
import con.he.SpringMini.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author tal
 * @Date 2021/9/6 5:21 下午
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) {
        //初始化工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 读取配置问价和注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        UserService service = (UserService) beanFactory.getBean("userService");
        service.queryUserInfo();
    }

}
