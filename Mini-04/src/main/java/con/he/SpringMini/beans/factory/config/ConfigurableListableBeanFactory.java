package con.he.SpringMini.beans.factory.config;

import con.he.SpringMini.beans.BeanException;
import con.he.SpringMini.beans.factory.ConfigurableBeanFactory;
import con.he.SpringMini.beans.factory.ListabelBeanFactory;

/**
 * @Author tal
 * @Date 2021/9/6 6:41 下午
 * @Version 1.0
 */
public interface ConfigurableListableBeanFactory extends ListabelBeanFactory ,AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    void preInstantiateSingletons() throws BeanException;


}
