import com.he.SpringMini.beans.PropertyValue;
import com.he.SpringMini.beans.PropertyValues;
import com.he.SpringMini.beans.factory.config.BeanDefinition;
import com.he.SpringMini.beans.factory.config.BeanFactoryPostProcessor;
import com.he.SpringMini.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author tal
 * @Date 2021/9/7 9:15 上午
 * @Version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","字节跳动"));

    }
}
