import con.he.SpringMini.beans.BeanException;
import con.he.SpringMini.beans.factory.config.BeanPostProcessor;

/**
 * @Author tal
 * @Date 2021/9/7 9:18 上午
 * @Version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException {
       // System.out.println("嘻嘻");
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException {

        return bean;
    }
}
